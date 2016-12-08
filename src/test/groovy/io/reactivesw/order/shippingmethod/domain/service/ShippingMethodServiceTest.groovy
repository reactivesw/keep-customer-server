package io.reactivesw.order.shippingmethod.domain.service

import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.common.model.action.SetName
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity
import io.reactivesw.order.shippingmethod.infrastructure.repository.ShippingMethodRepository
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/8.
 */
class ShippingMethodServiceTest extends Specification {

    ShippingMethodService service

    ShippingMethodRepository repository

    ShippingMethodEntity entity;

    def shippingMethodId = "tmpShippingMethodId"

    def locationId = "tmpLocationId"

    List<UpdateAction> actions

    def version = 1

    def setup() {
        repository = Mock(ShippingMethodRepository)
        service = new ShippingMethodService(repository: repository)
        entity = new ShippingMethodEntity(id: shippingMethodId, version: version)
        actions = new ArrayList<>()
    }

    def "Test 1.1: Create ShippingMethod"() {
        when:
        repository.save(_) >> entity
        ShippingMethodEntity result = service.createShippingMethod(entity)
        then:
        result != null
    }

    def "Test 2.1: Get ShippingMethod by id"() {
        when:
        repository.findOne(_) >> entity
        ShippingMethodEntity result = service.getById(shippingMethodId)
        then:
        result != null
    }

    def "Test 2.2: Get ShippingMethod by id that not exist"() {
        when:
        repository.findOne(_) >> null
        service.getById(shippingMethodId)
        then:
        thrown(NotExistException)
    }

    def "Test 2.3: Get ShippingMethod by location"() {

        when:
        service.getByLocation(locationId)
        then:
        noExceptionThrown()
    }

    def "Test 3.1: Update ShippingMethod"() {
        SetName setName = new SetName(name: "tmpName")
        actions.add(setName)
        when:
        repository.findOne(_) >> entity
        repository.save(_) >> entity
        ShippingMethodEntity result = service.update(shippingMethodId, version, actions)
        then:
        noExceptionThrown()
        result != null
    }

    def "Test 3.2: Update ShippingMethod with wrong version"() {
        SetName setName = new SetName(name: "tmpName")
        actions.add(setName)
        when:
        repository.findOne(_) >> entity
        service.update(shippingMethodId, version + 1, actions)
        then:
        thrown(ConflictException)
    }

    def "Test 4.1: Delete ShippingMethod "() {
        when:
        repository.findOne(_) >> entity
        service.deleteById(shippingMethodId, version)
        then:
        noExceptionThrown()
    }


}
