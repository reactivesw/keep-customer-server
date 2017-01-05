package io.reactivesw.order.shippingmethod.application.service

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.customer.customer.application.model.Address
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService
import io.reactivesw.order.zone.application.model.Location
import io.reactivesw.order.zone.application.model.Zone
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/20.
 */
class ShippingMethodApplicationTest extends Specification {

    ShippingMethodApplication application

    ShippingMethodService service = Mock(ShippingMethodService)

    RestTemplate restTemplate = Mock(RestTemplate)

    def setup() {
        application = new ShippingMethodApplication(service: service, restTemplate: restTemplate)
    }

    def "Test 1.1: get shipping method by country, state"() {

        List<Zone> zones = new ArrayList<>()
        Location location = new Location(country: "CN", state: "SZ")
        List<Location> locations = new ArrayList<>()
        locations.add(location)
        Zone zone = new Zone(id: "id", locations: locations)
        zones.add(zone)

        List<ShippingMethodEntity> entities = new ArrayList<>()
        ShippingMethodEntity entity = new ShippingMethodEntity(id: "id")
        entities.add(entity)

        when:
        restTemplate.getForObject(_, _) >> zones
        service.getByLocation(_) >> entities
        application.getByLocation("id", "CN")
        then:
        noExceptionThrown()
    }

    def "Test 1.2: get shipping method by country, state, currency"() {

        List<Zone> zones = new ArrayList<>()
        Location location = new Location(country: "CN", state: "SZ")
        List<Location> locations = new ArrayList<>()
        locations.add(location)
        Zone zone = new Zone(id: "id", locations: locations)
        zones.add(zone)

        List<ShippingMethodEntity> entities = new ArrayList<>()
        ShippingMethodEntity entity = new ShippingMethodEntity(id: "id")
        entities.add(entity)

        when:
        restTemplate.getForObject(_, _) >> zones
        service.getByLocation(_, _) >> entities

        application.getByLocation("id", "CN", "SZ")
        then:
        noExceptionThrown()
    }

    def "Test 1.3: get shipping method for special cart"() {

        List<Zone> zones = new ArrayList<>()
        Location location = new Location(country: "CN", state: "SZ")
        List<Location> locations = new ArrayList<>()
        locations.add(location)
        Zone zone = new Zone(id: "id", locations: locations)
        zones.add(zone)

        List<ShippingMethodEntity> entities = new ArrayList<>()
        ShippingMethodEntity entity = new ShippingMethodEntity(id: "id")
        entities.add(entity)

        Address address = new Address(country: "CN", state: "SZ")
        when:
        restTemplate.getForObject(_, Address.class) >> address
        restTemplate.getForObject(_, List.class) >> zones
        service.getByLocation(_) >> entities

        application.getShippingMethodsForCart("cartId")
        then:
        noExceptionThrown()
    }

    def "Test 1.4: get shipping method for special cart that shipping address not set"() {

        when:
        restTemplate.getForObject(_, Address.class) >> null

        application.getShippingMethodsForCart("cartId")
        then:
        thrown(NotExistException)
    }
}
