package io.reactivesw.order.cart.application.service.update

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.order.cart.application.model.action.RemoveLineItem
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/16.
 */
class RemoveLineItemServiceTest extends Specification {


    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 5;

    def lineItemId = "tmpLineItemId"

    CartEntity cartEntity

    RemoveLineItem removeLineItem

    RemoveLineItemService removeLineItemService

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, productId: productId, variant: variantId, quantity: quantity, supplyChannel: supplyChannel, distributionChannel: distributionChannel)
        lineItems.add(lineItem)

        cartEntity = new CartEntity(customerId: customerId, anonymousId: anonymousId, id: cartId, lineItems: lineItems)

        removeLineItem = new RemoveLineItem(lineItemId: lineItemId, quantity: quantity)

        removeLineItemService = new RemoveLineItemService()
    }

    def "Test 1.1: reduce line item quantity from cart"() {
        removeLineItem.setQuantity(quantity - 1)
        when:
        removeLineItemService.handle(cartEntity, removeLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: remove line item from cart"() {
        removeLineItem.setQuantity(quantity + 1)
        when:
        removeLineItemService.handle(cartEntity, removeLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.3: remove line item from cart by not set quantity"() {
        removeLineItem.setQuantity(null)
        when:
        removeLineItemService.handle(cartEntity, removeLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: remove non-existing line item from cart"() {
        removeLineItem.setLineItemId("fakeId")
        when:
        removeLineItemService.handle(cartEntity, removeLineItem)
        then:
        thrown(NotExistException)
    }

}
