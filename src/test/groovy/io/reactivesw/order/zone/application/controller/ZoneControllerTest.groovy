package io.reactivesw.order.zone.application.controller

import io.reactivesw.order.zone.application.model.Zone
import io.reactivesw.order.zone.application.model.mapper.ZoneMapper
import io.reactivesw.order.zone.domain.entity.LocationValue
import io.reactivesw.order.zone.domain.entity.ZoneEntity
import io.reactivesw.order.zone.domain.service.ZoneService
import spock.lang.Specification

import java.time.ZonedDateTime

/**
 * Created by umasuo on 16/12/20.
 */
class ZoneControllerTest extends Specification {


    ZoneController controller

    ZoneService service = Mock(ZoneService)

    def zoneId = "tmpZoneId"

    ZoneEntity zoneEntity
    Zone zone

    def setup() {
        controller = new ZoneController(service: service)

        Set<LocationValue> locations = new HashSet<>()
        locations.add(new LocationValue(country: "CN", state: "SZ"))
        zoneEntity = new ZoneEntity(id: "id", name: "name", description: "desc", version: 1, createdAt: ZonedDateTime.now(), lastModifiedAt: ZonedDateTime.now(), locations: locations)

        zone = ZoneMapper.entityToModel(zoneEntity)
    }

    def "Test 1.1: get by id"() {

        when:
        service.getById(_) >> zoneEntity
        Zone result = controller.getZoneById(zoneId)
        then:
        noExceptionThrown()
        result.getId() == zone.getId()

    }

    def "Test 1.2: get by location"() {

        List<ZoneEntity> zones = new ArrayList<>()
        zones.add(zoneEntity)
        when:
        service.getByLocation(_, _) >> zones
        List<Zone> result = controller.getByLocation("CN", "SZ")
        then:
        noExceptionThrown()
        result.size() == zones.size()

    }
}
