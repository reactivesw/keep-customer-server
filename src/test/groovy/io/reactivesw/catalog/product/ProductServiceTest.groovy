package io.reactivesw.catalog.product

import com.google.common.collect.Lists
import io.reactivesw.catalog.product.application.model.ProductDraft
import io.reactivesw.catalog.product.application.model.mapper.ProductMapper
import io.reactivesw.catalog.product.domain.entity.ProductCatalogDataEntity
import io.reactivesw.catalog.product.domain.entity.ProductDataEntity
import io.reactivesw.catalog.product.domain.entity.ProductEntity
import io.reactivesw.catalog.product.domain.service.ProductService
import io.reactivesw.catalog.product.infrastructure.repository.ProductRepository
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.LocalizedString
import io.reactivesw.common.model.Reference
import io.reactivesw.common.model.ResourceIdentifier
import org.apache.log4j.Category
import spock.lang.Specification

import java.time.ZonedDateTime

/**
 * Created by Davis on 16/12/15.
 */
class ProductServiceTest extends Specification {
    ProductRepository productRepository = Mock()
    def productService = new ProductService(productRepository: productRepository)
    def productDraft = new ProductDraft()
    def productEntity = new ProductEntity()
    def id = "12345678"
    def slug = "cup1111111"

    def setup() {
        def name = new LocalizedString()
        name.addKeyValue("en", "cup")
        productDraft.name = name

        productDraft.slug = slug

        def reference = new ResourceIdentifier(ReferenceTypes.PRODUCTTYPE.getType(), "123343434343434")
        productDraft.productType = reference

        productEntity = ProductMapper.modelToEntity(productDraft)
        productEntity.id = id
        productEntity.createdAt = ZonedDateTime.now()
        productEntity.lastModifiedAt = ZonedDateTime.now()
    }

    def "test 1.1 : create product"() {
        given:
        productRepository.save(_) >> productEntity

        when:
        def result = productService.createProduct(productDraft)

        then:
        result != null
        result.id != null
    }

    def "test 1.2 : create product and slug is same"() {
        given:
        productRepository.findAll() >> Lists.newArrayList(productEntity)
        productRepository.save(_) >> productEntity

        when:
        def result = productService.createProduct(productDraft)

        then:
        thrown(ConflictException)
    }

    def "test 1.3 : create product and slug is same"() {
        given:
        ProductEntity slugProduct = productEntity
        slugProduct.masterData.current.slug = slug + "current"
        slugProduct.masterData.staged.slug = slug + "staged"
        productRepository.findAll() >> Lists.newArrayList(slugProduct)
        productRepository.save(_) >> productEntity

        when:
        def result = productService.createProduct(productDraft)

        then:
        result != null
        result.id != null
    }

    def "test 2.1 : delete product"() {
        given:
        def version = 1
        productEntity.version = version
        productRepository.findOne(_) >> productEntity

        when:
        productService.deleteProduct(id, version)

        then:
        true;
    }

    def "test 2.2 : delete product and version not match"() {
        given:
        def version = 1
        productEntity.version = version + 1
        productRepository.findOne(_) >> productEntity

        when:
        productService.deleteProduct(id, version)

        then:
        thrown(ConflictException)
    }


    def "test 4.1 : get Product by Id"() {
        given:
        productRepository.findOne(id) >> productEntity

        when:
        def result = productService.getProductById(id)

        then:
        result != null
        result.id == id
    }

    def "test 4.2 : get Product by Id and get null"() {
        given:
        productRepository.findOne(id) >> null

        when:
        def result = productService.getProductById(id)

        then:
        thrown(NotExistException)
    }

    def "test 5.1 : get product by category id"() {
        given:
        def categoryId = "111111111111"
        ProductCatalogDataEntity masterData = new ProductCatalogDataEntity();
        ProductDataEntity currentData = new ProductDataEntity()
        currentData.categories = Lists.newArrayList(categoryId)
        masterData.current = currentData
        productEntity.masterData = masterData
        productRepository.findAll() >> Lists.newArrayList(productEntity)

        when:
        def result = productService.queryProductByCategory(categoryId)

        then:
        result != null
    }

    def "test 6.1 : get product by slug"() {
        given:
        def productSlug = slug
        List<ProductEntity> products = Lists.newArrayList(productEntity)
        productRepository.findAll() >> products

        when:
        def result = productService.getProductBySlug(productSlug)

        then:
        result != null
    }

    def "test 6.1 : get product by slug and can not match slug"() {
        given:
        def productSlug = slug + "11"
        List<ProductEntity> products = Lists.newArrayList(productEntity)
        productRepository.findAll() >> products

        when:
        def result = productService.getProductBySlug(productSlug)

        then:
        result != null
    }
}
