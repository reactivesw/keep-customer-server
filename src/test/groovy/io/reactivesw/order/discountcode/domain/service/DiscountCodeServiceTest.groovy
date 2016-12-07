package io.reactivesw.order.discountcode.domain.service

import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.ImmutableException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.order.discountcode.application.model.action.SetActive
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity
import io.reactivesw.order.discountcode.infrastructure.repository.DiscountCodeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/29.
 */
class DiscountCodeServiceTest extends Specification {

    Logger LOG = LoggerFactory.getLogger(DiscountCodeServiceTest)


    DiscountCodeRepository discountCodeRepository

    DiscountCodeService discountCodeService

    DiscountCodeEntity discountCodeEntity

    def discountCodeId = "tmpDiscountCodeId"

    def version = 1

    List<UpdateAction> updateActions

    def setup() {
        LOG.info("init discount code service test.")
        discountCodeRepository = Mock(DiscountCodeRepository)
        discountCodeService = new DiscountCodeService(discountCodeRepository: discountCodeRepository)
        discountCodeEntity = new DiscountCodeEntity(id: discountCodeId, version: 1, code: "ERTYUIJHGFDCVBN", active: false, cartPredicate: "customerId=QWEYUIOJH")
        updateActions = new ArrayList<>()

    }

    def "Test 1.1: Create new DiscountCode "() {
        when:
        discountCodeRepository.save(_) >> discountCodeEntity
        DiscountCodeEntity entity = discountCodeService.createDiscountCode(discountCodeEntity)
        then:
        entity != null
    }

    def "Test 2.1: Get DiscountCode by Id"() {
        when:
        discountCodeRepository.findOne(_) >> discountCodeEntity
        DiscountCodeEntity entity = discountCodeService.getById(discountCodeId)
        then:
        entity != null
    }

    def "Test 2.2: Get DiscountCode by Id with not exist"() {
        when:
        discountCodeRepository.findOne(_) >> null
        discountCodeService.getById(discountCodeId)
        then:
        thrown(NotExistException)
    }

    def "Test 3.1: Update DiscountCode"() {
        SetActive active = new SetActive(isActive: true)
        updateActions.add(active)
        when:
        discountCodeRepository.findOne(_) >> discountCodeEntity
        discountCodeRepository.save(_) >> discountCodeEntity
        discountCodeService.update(discountCodeId, version, updateActions)
        then:
        noExceptionThrown()
    }

    def "Test 3.2: Update DiscountCode"() {
        when:
        discountCodeRepository.findOne(_) >> discountCodeEntity
        discountCodeRepository.save(_) >> discountCodeEntity
        discountCodeService.update(discountCodeId, 11, updateActions)
        then:
        thrown(ConflictException)
    }

    def "Test 3.3: Update DiscountCode"() {
        when:
        discountCodeEntity.setActive(true)
        discountCodeRepository.findOne(_) >> discountCodeEntity
        discountCodeRepository.save(_) >> discountCodeEntity
        discountCodeService.update(discountCodeId, version, updateActions)
        then:
        thrown(ImmutableException)
    }
}
