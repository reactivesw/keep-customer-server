package io.reactivesw.catalog.inventory

import io.reactivesw.catalog.inventory.application.model.InventoryEntryDraft
import io.reactivesw.catalog.inventory.application.model.mapper.InventoryEntryMapper
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity
import io.reactivesw.catalog.inventory.domain.service.InventoryEntryService
import io.reactivesw.catalog.inventory.infrastructure.repository.InventoryEntryRepository
import io.reactivesw.common.enums.ReferenceTypes
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

    def setup() {
        inventoryEntryDraft.sku = "sku"
        inventoryEntryDraft.expectedDelivery = ZonedDateTime.now()
        inventoryEntryDraft.supplyChannel = new Reference(ReferenceTypes.CHANNEL.getType(), "q.ksfdkhsdfdf")
        inventoryEntryDraft.quantityOnStock = 120
        inventoryEntryDraft.restockableInDays = 12
        inventoryEntryDraft.custom = null

        inventoryEntryEntity = InventoryEntryMapper.modelToEntity(inventoryEntryDraft)
    }

    def "test 1 : create inventory entry"() {
        given:
        inventoryEntryRepository.save(_) >> inventoryEntryEntity

        when:
        def result = inventoryEntryService.createInventoryEntry(inventoryEntryDraft)

        then:
        result != null
    }
}
