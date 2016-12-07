package io.reactivesw.catalog.producttype.domain.service

import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity
import io.reactivesw.catalog.producttype.infrastructure.repository.ProductTypeRepository
import spock.lang.Specification

/**
 * Created by Davis on 16/12/7.
 */
class ProductTypeServiceTest extends Specification {

    ProductTypeRepository productTypeRepository = Mock()
    ProductTypeService productTypeService = new ProductTypeService(productTypeRepository: productTypeRepository)
    def entity = new ProductTypeEntity()


    def "test 1.1 : create product type"() {
        given:
        def draft = new ProductTypeDraft()
        productTypeRepository.save(_) >> entity

        when:
        def result = productTypeService.createProductType(draft)

        then:
        result != null
    }
}
