package io.reactivesw.catalog.product

import io.reactivesw.catalog.product.application.model.ProductDraft
import io.reactivesw.catalog.product.application.model.mapper.ProductMapper
import io.reactivesw.catalog.product.domain.entity.ProductEntity
import io.reactivesw.catalog.product.domain.service.ProductService
import io.reactivesw.catalog.product.infrastructure.repository.ProductRepository
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.LocalizedString
import io.reactivesw.common.model.Reference
import io.reactivesw.common.model.ResourceIdentifier
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

    def setup() {
        def name = new LocalizedString()
        name.addKeyValue("en", "cup")
        productDraft.name = name

        def slug = new LocalizedString()
        slug.addKeyValue("en", "cup-111111")
        productDraft.slug

        def reference = new ResourceIdentifier(ReferenceTypes.PRODUCTTYPE.getType(), "123343434343434")
        productDraft.productType = reference

        productEntity = ProductMapper.modelToEntity(productDraft)
        productEntity.id = id
        productEntity.createdAt = ZonedDateTime.now()
        productEntity.lastModifiedAt = ZonedDateTime.now()
    }

    def "test 1.1 create product"() {
        given:
        productRepository.save(_) >> productEntity

        when:
        def result = productService.createProduct(productDraft)

        then:
        result != null
        result.id != null
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
}
