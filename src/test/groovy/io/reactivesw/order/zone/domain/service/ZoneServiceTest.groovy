package io.reactivesw.order.zone.domain.service

import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.common.model.action.SetName
import io.reactivesw.order.zone.domain.entity.ZoneEntity
import io.reactivesw.order.zone.infrastructure.repository.ZoneRepository
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/8.
 */
class ZoneServiceTest extends Specification {

    ZoneRepository repository

    ZoneService zoneService

    ZoneEntity zoneEntity

    def zoneId = "tmpZoneId"

    def version = 1

    List<UpdateAction> actions

    def setup() {
        repository = Mock(ZoneRepository)
        zoneService = new ZoneService(zoneRepository: repository)
        zoneEntity = new ZoneEntity(id: zoneId, version: version)
        actions = new ArrayList<>()
    }

    def "Test 1.1: Create Zone."() {
        when:
        repository.save(_) >> zoneEntity
        ZoneEntity entity = zoneService.createZone(zoneEntity)
        then:
        entity != null
        noExceptionThrown()
    }

    def "Test 2.1: Get Zone By id."() {
        when:
        repository.findOne(_) >> zoneEntity
        ZoneEntity entity = zoneService.getById(zoneId)
        then:
        entity != null
        noExceptionThrown()
    }

    def "Test 2.2: Get Zone By id that do not exist."() {
        when:
        zoneService.getById(zoneId)
        then:
        thrown(NotExistException)
    }

    def "Test 3.1: Update Zone."() {
        SetName setName = new SetName(name: "tmpName")
        actions.add(setName)
        when:
        repository.findOne(_) >> zoneEntity
        repository.save(_) >> zoneEntity
        ZoneEntity entity = zoneService.updateZone(zoneId, version, actions)
        then:
        entity != null
        noExceptionThrown()
    }

    def "Test 3.2: Update Zone with wrong version"() {
        SetName setName = new SetName(name: "tmpName")
        actions.add(setName)
        when:
        repository.findOne(_) >> zoneEntity
        repository.save(_) >> zoneEntity
        zoneService.updateZone(zoneId, version + 1, actions)
        then:
        thrown(ConflictException)
    }

    def "Test 4.1: Delete version"() {

        when:
        repository.findOne(_) >> zoneEntity
        zoneService.deleteById(zoneId, version)
        then:
        noExceptionThrown()
    }
}
