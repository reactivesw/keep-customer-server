package io.reactivesw.catalog.product

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.Lists
import io.reactivesw.catalog.inventory.application.model.InventoryEntry
import io.reactivesw.catalog.product.application.ProductApplication
import io.reactivesw.catalog.product.application.ProductRestClient
import io.reactivesw.catalog.product.application.model.Product
import io.reactivesw.catalog.product.application.model.ProductDraft
import io.reactivesw.catalog.product.application.model.ProductVariantDraft
import io.reactivesw.catalog.product.application.model.attributes.Attribute
import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition
import io.reactivesw.catalog.product.application.model.mapper.ProductMapper
import io.reactivesw.catalog.product.domain.entity.ProductEntity
import io.reactivesw.catalog.product.domain.service.ProductService
import io.reactivesw.catalog.producttype.application.model.ProductType
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.exception.ParametersException
import io.reactivesw.common.model.LocalizedString
import io.reactivesw.common.model.ResourceIdentifier
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import java.time.ZonedDateTime

/**
 * Created by Davis on 16/12/19.
 */
class ProductApplicationTest extends Specification {

    ProductRestClient productRestClient = Mock()
    ProductService productService = Mock()
    def productApplication = new ProductApplication(productRestClient: productRestClient, productService: productService)
    def productDraft = new ProductDraft()
    def productEntity = new ProductEntity()
    def id = "12345678"
    def productType = new ProductType()
    def product = new Product()
    def productTypeId = "123343434343434"
    ObjectMapper mapper = new ObjectMapper();

    AttributeDefinition noneAttribute = new AttributeDefinition()
    AttributeDefinition uniqueAttribute = new AttributeDefinition()
    AttributeDefinition combinationAttribute = new AttributeDefinition()
    AttributeDefinition sameAttribute = new AttributeDefinition()
    AttributeDefinition requireAttribute = new AttributeDefinition()
    List<AttributeDefinition> attributeDefinitions = Lists.newArrayList()

    def setup() {
        def name = new LocalizedString()
        name.addKeyValue("en", "cup")
        productDraft.name = name

        def slug = new LocalizedString()
        slug.addKeyValue("en", "cup-111111")
        productDraft.slug = slug

        def reference = new ResourceIdentifier(ReferenceTypes.PRODUCTTYPE.getType(), productTypeId)
        productDraft.productType = reference

        productEntity = ProductMapper.modelToEntity(productDraft)
        productEntity.id = id
        productEntity.createdAt = ZonedDateTime.now()
        productEntity.lastModifiedAt = ZonedDateTime.now()

        product = ProductMapper.entityToModel(productEntity)

        productType.id = productTypeId

        noneAttribute = new AttributeDefinition()
        noneAttribute.attributeConstraint = AttributeConstraint.None
        noneAttribute.name = "none attribute"
        noneAttribute.isRequired = false

        uniqueAttribute = new AttributeDefinition()
        uniqueAttribute.attributeConstraint = AttributeConstraint.Unique
        uniqueAttribute.name = "unique attribute"
        uniqueAttribute.isRequired = false

        combinationAttribute = new AttributeDefinition()
        combinationAttribute.attributeConstraint = AttributeConstraint.CombinationUnique
        combinationAttribute.name = "combination unique attribute"
        combinationAttribute.isRequired = false

        sameAttribute = new AttributeDefinition()
        sameAttribute.attributeConstraint = AttributeConstraint.SameForAll
        sameAttribute.name = "same for all attribute"
        sameAttribute.isRequired = false

        requireAttribute = new AttributeDefinition()
        requireAttribute.attributeConstraint = AttributeConstraint.None
        requireAttribute.name = "require attribute"
        requireAttribute.isRequired = true
        attributeDefinitions = Lists.newArrayList(noneAttribute, uniqueAttribute, combinationAttribute, sameAttribute, requireAttribute)

        productType.attributes = attributeDefinitions
    }

    def "test 1.1 : create product without require attribute"() {
        given:
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.2 : create product with require attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute)
        masterVariant.attributes = attributes
        productDraft.masterVariant = masterVariant
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        result != null
    }

    def "test 1.3 : create product with not exist attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "not exist attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1)
        masterVariant.attributes = attributes
        productDraft.masterVariant = masterVariant
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.4 : create product without unique attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "unique attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute2)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.5 : create product with unique attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "unique attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value2)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute2)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        result != null
    }

    def "test 1.6 : create product with combination unique attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "unique attribute", value: value)
        Attribute attribute2 = new Attribute(name: "combination unique attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1, attribute2)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value2)
        Attribute skuAttribute3 = new Attribute(name: "combination unique attribute", value: value2)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute2, skuAttribute3)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        result != null
    }

    def "test 1.7 : create product without combination unique attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "unique attribute", value: value)
        Attribute attribute2 = new Attribute(name: "combination unique attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1, attribute2)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value2)
        Attribute skuAttribute3 = new Attribute(name: "combination unique attribute", value: value)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute2, skuAttribute3)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.8 : create product and get null product type by resttemplate"() {
        given:
        productRestClient.getProductType(_) >> null
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(NotExistException)
    }

    def "test 1.9 : create product when product type has no attributedefinition"() {
        given:
        productType.attributes = null
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        productApplication.createProduct(productDraft)

        then:
        true
    }

    def "test 1.9 : create product with same for all attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "unique attribute", value: value)
        Attribute attribute2 = new Attribute(name: "combination unique attribute", value: value)
        Attribute attribute3 = new Attribute(name: "same for all attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1, attribute2, attribute3)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value2)
        Attribute skuAttribute3 = new Attribute(name: "combination unique attribute", value: value2)
        Attribute skuAttribute4 = new Attribute(name: "same for all attribute", value: value)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute2, skuAttribute3, skuAttribute4)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        result != null
    }

    def "test 1.10 : create product without same for all attribute"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute1 = new Attribute(name: "unique attribute", value: value)
        Attribute attribute2 = new Attribute(name: "combination unique attribute", value: value)
        Attribute attribute3 = new Attribute(name: "same for all attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute1, attribute2, attribute3)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value2)
        Attribute skuAttribute3 = new Attribute(name: "combination unique attribute", value: value2)
        Attribute skuAttribute4 = new Attribute(name: "same for all attribute", value: value2)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute2, skuAttribute3, skuAttribute4)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.11 : create product with require attribute but have no masterVariant"() {
        given:
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def " test 1.12 : create product with require attribute and variants have null attributes"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.13 :  create product with require attributes and variants have no require attributes"() {
        given:
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute2 = new Attribute(name: "unique attribute", value: value2)
        Attribute skuAttribute3 = new Attribute(name: "combination unique attribute", value: value2)
        Attribute skuAttribute4 = new Attribute(name: "same for all attribute", value: value2)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute2, skuAttribute3, skuAttribute4)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        thrown(ParametersException)
    }

    def "test 1.14 : create product with product type has no unique attribute definition"() {
        given:
        attributeDefinitions = Lists.newArrayList(noneAttribute, combinationAttribute, sameAttribute, requireAttribute)
        productType.attributes = attributeDefinitions
        JsonNode value = mapper.readTree("\"require attribute value\"");
        ProductVariantDraft masterVariant = new ProductVariantDraft()
        masterVariant.sku = "master sku"
        Attribute attribute = new Attribute(name: "require attribute", value: value)
        Attribute attribute2 = new Attribute(name: "combination unique attribute", value: value)
        Attribute attribute3 = new Attribute(name: "same for all attribute", value: value)
        List<Attribute> attributes = Lists.newArrayList(attribute, attribute2, attribute3)
        masterVariant.attributes = attributes

        ProductVariantDraft variantDraft = new ProductVariantDraft()
        variantDraft.sku = "variant sku"
        Attribute skuAttribute1 = new Attribute(name: "require attribute", value: value)
        JsonNode value2 = mapper.readTree("\"require attribute value2\"");
        Attribute skuAttribute3 = new Attribute(name: "combination unique attribute", value: value2)
        Attribute skuAttribute4 = new Attribute(name: "same for all attribute", value: value)
        List<Attribute> variantAttributes = Lists.newArrayList(skuAttribute1, skuAttribute3, skuAttribute4)
        variantDraft.attributes = variantAttributes
        List<ProductVariantDraft> variantDrafts = Lists.newArrayList(variantDraft)

        productDraft.masterVariant = masterVariant
        productDraft.variants = variantDrafts
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        result != null
    }

    def "test 1.15 : create product without master variant and product type has no attribute"() {
        given:
        attributeDefinitions = Lists.newArrayList(noneAttribute)
        productType.attributes = attributeDefinitions
        productRestClient.getProductType(_) >> productType
        productService.createProduct(productDraft) >> product

        when:
        def result = productApplication.createProduct(productDraft)

        then:
        result != null
    }

    def "test 2.1 : get Product by Id"() {
        given:
        List<InventoryEntry> inventoryEntries = Lists.newArrayList()
        productService.getProductById(_) >> product
        productRestClient.getInventoryEntry(_) >> inventoryEntries

        when:
        def result = productApplication.getProductById(id)

        then:
        result != null
    }

    def "test 2.2 : get Product by Id and get null inventory entry"() {
        given:
        productService.getProductById(_) >> product
        productRestClient.getInventoryEntry(_) >> null

        when:
        def result = productApplication.getProductById(id)

        then:
        result != null
    }
}
