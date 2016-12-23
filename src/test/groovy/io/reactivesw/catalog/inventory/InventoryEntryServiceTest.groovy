package io.reactivesw.catalog.inventory

import com.google.common.collect.Lists
import io.reactivesw.catalog.inventory.application.model.InventoryEntryDraft
import io.reactivesw.catalog.inventory.application.model.action.SetExpectedDelivery
import io.reactivesw.catalog.inventory.application.model.mapper.InventoryEntryMapper
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity
import io.reactivesw.catalog.inventory.domain.service.InventoryEntryService
import io.reactivesw.catalog.inventory.infrastructure.repository.InventoryEntryRepository
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.Reference
import io.reactivesw.common.model.UpdateAction
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
    def skuName = "sku"

    def setup() {
        inventoryEntryDraft.sku = skuName
        inventoryEntryDraft.expectedDelivery = ZonedDateTime.now()
        inventoryEntryDraft.supplyChannel = new Reference(ReferenceTypes.CHANNEL.getType(), "q.ksfdkhsdfdf")
        inventoryEntryDraft.quantityOnStock = 120
        inventoryEntryDraft.restockableInDays = 12
        inventoryEntryDraft.custom = null

        inventoryEntryEntity = InventoryEntryMapper.modelToEntity(inventoryEntryDraft)
        inventoryEntryEntity.id = id
        inventoryEntryEntity.version = version
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

    def "test 3.1 : update inventory entry"() {
        given:
        inventoryEntryRepository.findOne(id) >> inventoryEntryEntity
        inventoryEntryRepository.save(_) >> inventoryEntryEntity
        SetExpectedDelivery action = new SetExpectedDelivery(expectedDelivery: ZonedDateTime.now())
        List<UpdateAction> actions = Lists.newArrayList(action)

        when:
        def result = inventoryEntryService.updateInventoryEntry(id, version, actions)

        then:
        result != null
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

    def "test 5.1 : query inventory entry by sku names"() {
        given:
        def skuNames = Lists.newArrayList(skuName)
        def inventoryList = Lists.newArrayList(inventoryEntryEntity)
        inventoryEntryRepository.queryBySkuNames(skuNames) >> inventoryList

        when:
        def result = inventoryEntryService.queryBySkuNames(skuNames)

        then:
        result != null
        result.size() == inventoryList.size()
    }

    def "test 5.2 : query inventory entry by sku names and get null result"() {
        given:
        def skuNames = Lists.newArrayList(skuName)
        inventoryEntryRepository.queryBySkuNames(skuNames) >> null

        when:
        def result = inventoryEntryService.queryBySkuNames(skuNames)

        then:
        result != null
        result.size() == 0
    }
}
