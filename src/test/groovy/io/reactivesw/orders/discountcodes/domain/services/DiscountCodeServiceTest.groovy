package io.reactivesw.orders.discountcodes.domain.services

import io.reactivesw.common.exceptions.AlreadyExistException
import io.reactivesw.common.exceptions.NotExistException
import io.reactivesw.common.exceptions.ParametersException
import io.reactivesw.orders.carts.domains.entities.CartEntity
import io.reactivesw.orders.carts.domains.entities.values.LineItemValue
import io.reactivesw.orders.carts.domains.entities.values.ProductVariantValue
import io.reactivesw.orders.carts.domains.services.CartService
import io.reactivesw.orders.carts.infrastructures.enums.CartState
import io.reactivesw.orders.carts.infrastructures.repositories.CartRepository
import io.reactivesw.orders.discountcodes.domains.entities.DiscountCodeEntity
import io.reactivesw.orders.discountcodes.domains.services.DiscountCodeService
import io.reactivesw.orders.discountcodes.repositories.DiscountCodeRepository
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

    def setup() {
        LOG.info("init discount code service test.")
        discountCodeRepository = Mock(DiscountCodeRepository)
        discountCodeService = new DiscountCodeService(discountCodeRepository: discountCodeRepository)
        discountCodeEntity = new DiscountCodeEntity(id: discountCodeId, version: 1, code: "ERTYUIJHGFDCVBN", active: true, cartPredicate: "customerId=QWEYUIOJH")
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
        when:
        discountCodeRepository.findOne(_) >> discountCodeEntity
        discountCodeRepository.save(_) >> discountCodeEntity
        discountCodeService.update(version, discountCodeEntity)
        then:
        noExceptionThrown()
    }

}
