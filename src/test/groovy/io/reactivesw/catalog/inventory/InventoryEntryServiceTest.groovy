package io.reactivesw.catalog.inventory

import io.reactivesw.catalog.inventory.application.model.InventoryEntryDraft
import io.reactivesw.catalog.inventory.application.model.mapper.InventoryEntryMapper
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity
import io.reactivesw.catalog.inventory.domain.service.InventoryEntryService
import io.reactivesw.catalog.inventory.infrastructure.repository.InventoryEntryRepository
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.Reference
import spock.lang.Specification

import java.time.ZonedDateTime

/**
 * Created by Davis on 16/12/21.
 */
class InventoryEntryServiceTest extends Specification {
    InventoryEntryRepository inventoryEntryRepository = Mock()
    def inventoryEntryService = new InventoryEntryService(inventoryEntryRepository: inventoryEntryRepository)
    def inventoryEntryDraft = new InventoryEntryDraft()
    def inventoryEntryEntity = new InventoryEntryEntity()
    def id = "1234566"
    def version = 1

    def setup() {
        inventoryEntryDraft.sku = "sku"
        inventoryEntryDraft.expectedDelivery = ZonedDateTime.now()
        inventoryEntryDraft.supplyChannel = new Reference(ReferenceTypes.CHANNEL.getType(), "q.ksfdkhsdfdf")
        inventoryEntryDraft.quantityOnStock = 120
        inventoryEntryDraft.restockableInDays = 12
        inventoryEntryDraft.custom = null

        inventoryEntryEntity = InventoryEntryMapper.modelToEntity(inventoryEntryDraft)
        inventoryEntryEntity.id = id
    }

    def "test 1 : create inventory entry"() {
        given:
        inventoryEntryRepository.save(_) >> inventoryEntryEntity

        when:
        def result = inventoryEntryService.createInventoryEntry(inventoryEntryDraft)

        then:
        result != null
    }

    def "test 2.1 : delete inventory entry"() {
        given:
        inventoryEntryEntity.version = version
        inventoryEntryRepository.findOne(id) >> inventoryEntryEntity

        when:
        inventoryEntryService.deleteInventoryEntry(id, version)

        then:
        true
    }

    def "test 2.2 : delete inventory entry and version not match"() {
        given:
        inventoryEntryEntity.version = version + 1
        inventoryEntryRepository.findOne(id) >> inventoryEntryEntity

        when:
        inventoryEntryService.deleteInventoryEntry(id, version)

        then:
        thrown(ConflictException)
    }

    def "test 4.1 : get inventory entry by id"() {
        given:
        inventoryEntryRepository.findOne(id) >> inventoryEntryEntity

        when:
        def result = inventoryEntryService.getInventoryEntryById(id)

        then:
        result != null
        result.id == id
    }

    def "test 4.2 : get inventory entry by id and get null entity"() {
        given:
        inventoryEntryRepository.findOne(id) >> null

        when:
        def result = inventoryEntryService.getInventoryEntryById(id)

        then:
        thrown(NotExistException)
    }
}
