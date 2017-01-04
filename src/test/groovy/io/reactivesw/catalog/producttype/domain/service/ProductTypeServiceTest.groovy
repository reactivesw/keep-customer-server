package io.reactivesw.catalog.producttype.domain.service

import com.google.common.collect.Lists
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft
import io.reactivesw.catalog.producttype.application.model.mapper.ProductTypeMapper
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity
import io.reactivesw.catalog.producttype.domain.service.update.ProductTypeUpdateService
import io.reactivesw.catalog.producttype.infrastructure.repository.ProductTypeRepository
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.QueryConditions
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.common.model.action.SetName
import spock.lang.Specification

/**
 * Created by Davis on 16/12/7.
 */
class ProductTypeServiceTest extends Specification {

    ProductTypeUpdateService productTypeUpdateService = Mock()
    ProductTypeRepository productTypeRepository = Mock()
    ProductTypeService productTypeService = new ProductTypeService(productTypeRepository: productTypeRepository,
            updateService: productTypeUpdateService)
    def entity = new ProductTypeEntity()
    def draft = new ProductTypeDraft()
    def id = "1111111"
    def version = 1
    def key = "T Shirt"

    def setup() {
        draft.name = "T Shirt"
        draft.key = key

        entity = ProductTypeMapper.modelToEntity(draft)
        entity.id = id
    }


    def "test 1.1 : create product type"() {
        given:
        productTypeRepository.save(_) >> entity

        when:
        def result = productTypeService.createProductType(draft)

        then:
        result != null
        result.name == entity.name
        result.key == entity.key
    }

    def "test 2.1.1 : delete product type by id"() {
        given:
        entity.version = version
        productTypeRepository.findOne(id) >> entity

        when:
        productTypeService.deleteProductTypeById(id, version)

        then:
        true
    }

    def "test 2.1.2 : delete product type and get null product type"() {
        given:

        productTypeRepository.findOne(_) >> null

        when:
        productTypeService.deleteProductTypeById(id, version)

        then:
        thrown(NotExistException)
    }

    def "test 2.1.3 : delete product type by id and version not match"() {
        given:
        entity.version = version + 1
        productTypeRepository.findOne(id) >> entity

        when:
        productTypeService.deleteProductTypeById(id, version)

        then:
        thrown(ConflictException)
    }

    def "test 2.2.1 : delete product type by key"() {
        given:
        entity.version = version
        def key = entity.key
        productTypeRepository.findDistinctProductTypeByKey(key) >> entity

        when:
        productTypeService.deleteProductTypeByKey(key, version)

        then:
        true
    }

    def "test 2.2.2 : delete product type by key and get null product type"() {
        given:
        productTypeRepository.findDistinctProductTypeByKey(key) >> null

        when:
        productTypeService.deleteProductTypeByKey(key, version)

        then:
        thrown(NotExistException)
    }

    def "test 3.1 : update product type by id"() {
        given:
        List<UpdateAction> actions = new ArrayList<>()
        SetName setName = new SetName(name: "new TShirt")
        actions.add(setName)
        entity.version = version
        productTypeRepository.findOne(id) >> entity
        productTypeRepository.save(entity) >> entity

        when:
        def result = productTypeService.updateProductTypeById(id, version, actions)

        then:
        result != null
    }

    def "test 3.2 : update product type by key"() {
        given:
        List<UpdateAction> actions = new ArrayList<>()
        entity.version = version
        productTypeRepository.findDistinctProductTypeByKey(key) >> entity
        productTypeRepository.save(entity) >> entity

        when:
        def result = productTypeService.updateProductTypeByKey(key, version, actions)

        then:
        result != null
    }

    def "test 4.1 : get product type by id"() {
        given:
        productTypeRepository.findOne(id) >> entity

        when:
        def result = productTypeService.getProductTypeById(id)

        then:
        result != null
        result.id == id
        result.name == entity.name
    }

    def "test 4.2 : get product type by key"() {
        given:
        productTypeRepository.findDistinctProductTypeByKey(key) >> entity

        when:
        def result = productTypeService.getProductTypeByKey(key)

        then:
        result != null
        result.key == key
    }

    def "test 4.3 : query ProductType by QueryConditions"() {
        given:
        QueryConditions queryConditions = new QueryConditions()
        List<ProductTypeEntity> entities = Lists.newArrayList(entity)
        productTypeRepository.findAll() >> entities

        when:
        def result = productTypeService.queryProductTypes(queryConditions)

        then:
        result != null
        result.results.size() == entities.size()
    }
}
