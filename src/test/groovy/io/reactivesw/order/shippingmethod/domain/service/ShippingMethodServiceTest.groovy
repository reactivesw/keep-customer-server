package io.reactivesw.order.shippingmethod.domain.service

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.common.model.action.SetName
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue
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


    List<UpdateAction> actions

    def version = 1

    def locationId1 = "tmpLocationId1"
    def locationId2 = "tmpLocationId2"
    List<ShippingMethodEntity> allMethods
    ShippingMethodEntity method1
    ShippingMethodEntity method2
    ZoneRateValue zoneRate1
    ZoneRateValue zoneRate2
    ShippingRateValue shippingRate1
    ShippingRateValue shippingRate2

    def setup() {
        repository = Mock(ShippingMethodRepository)
        service = new ShippingMethodService(repository: repository)
        entity = new ShippingMethodEntity(id: shippingMethodId, version: version)
        actions = new ArrayList<>()

        shippingRate1 = new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120))
        shippingRate2 = new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120))
        Set<ShippingRateValue> shippingRates = new HashSet<>()
        shippingRates.add(shippingRate1)
        shippingRates.add(shippingRate2)
        zoneRate1 = new ZoneRateValue(zone: locationId1, shippingRates: shippingRates)
        zoneRate2 = new ZoneRateValue(zone: locationId2, shippingRates: shippingRates)
        Set<ZoneRateValue> zoneRates = new HashSet<>()
        zoneRates.add(zoneRate1)
        zoneRates.add(zoneRate2)
        method1 = new ShippingMethodEntity(id: "method1", version: version, zoneRates: zoneRates)
        method2 = new ShippingMethodEntity(id: "method2", version: version, zoneRates: zoneRates)
        allMethods = new ArrayList<>()
        allMethods.add(method1)
        allMethods.add(method2)
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
        repository.findAll() >> allMethods
        List<ShippingMethodEntity> result = service.getByLocation(locationId1)
        then:
        noExceptionThrown()
        result.size() == 2
    }

    def "Test 2.4: Get ShippingMethod by location id, that not exist"() {

        when:
        repository.findAll() >> allMethods
        List<ShippingMethodEntity> result = service.getByLocation("fakeId")
        then:
        noExceptionThrown()
        result.size() == 0
    }

    def "Test 2.5: Get ShippingMethod by location id and currency"() {

        when:
        repository.findAll() >> allMethods
        List<ShippingMethodEntity> result = service.getByLocation(locationId1,"RMB")
        then:
        noExceptionThrown()
        result.size() == 2
    }

    def "Test 2.6: Get ShippingMethod by location id and wrong currency"() {

        when:
        repository.findAll() >> allMethods
        List<ShippingMethodEntity> result = service.getByLocation(locationId1,"fakeCurrency")
        then:
        noExceptionThrown()
        result.size() == 0
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
