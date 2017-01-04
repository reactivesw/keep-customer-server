package io.reactivesw.order.cart.application.service.update

import io.reactivesw.common.model.Update
import io.reactivesw.order.cart.application.model.action.AddLineItem
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class CartUpdateServiceTest extends Specification {

    AddLineItem addLineItem = Mock(AddLineItem)
    AddLineItemService addLineItemService = Mock(AddLineItemService)

    Map<Class<?>, Update> updateMappers = Mock(HashMap)

    CartUpdateService cartUpdateService

    CartEntity cart

    def setup() {
        cartUpdateService = new CartUpdateService(updateMappers: updateMappers)
        cart = new CartEntity()
    }

    def "Test 1.1: add lineItem"() {
        when:
        cartUpdateService.handle(cart, addLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: add lineItem"() {
        when:
        updateMappers.get(addLineItem.class) >> addLineItemService
        cartUpdateService.handle(cart, addLineItem)
        then:
        noExceptionThrown()
    }
}