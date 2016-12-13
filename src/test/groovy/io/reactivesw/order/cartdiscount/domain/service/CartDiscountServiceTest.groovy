package io.reactivesw.order.cartdiscount.domain.service

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity
import io.reactivesw.order.cartdiscount.infrastructure.repository.CartDiscountRepository
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/13.
 */
class CartDiscountServiceTest extends Specification {

    CartDiscountRepository cartDiscountRepository

    CartDiscountService cartDiscountService

    CartDiscountEntity entity

    def id = "tempCartDiscountId"

    def version = 1

    def setup() {
        cartDiscountRepository = Mock(CartDiscountRepository)
        cartDiscountService = new CartDiscountService(repository: cartDiscountRepository)

        entity = new CartDiscountEntity(id: id, version: version)
    }

    def "Test 1.1: Get cart discount by id"() {

        when:
        cartDiscountRepository.findOne(_) >> entity
        CartDiscountEntity result = cartDiscountService.getById(id)
        then:
        noExceptionThrown()
        result != null

    }


    def "Test 1.2: Get cart discount by id that not exist"() {

        when:
        cartDiscountRepository.findOne(_) >> null
        cartDiscountService.getById(id)
        then:
        thrown(NotExistException)
    }

    def "Test 2.1: Create cart discount"() {
        when:
        cartDiscountRepository.save(_) >> entity
        CartDiscountEntity result = cartDiscountService.create(entity)
        then:
        noExceptionThrown()
        result != null
    }
}
