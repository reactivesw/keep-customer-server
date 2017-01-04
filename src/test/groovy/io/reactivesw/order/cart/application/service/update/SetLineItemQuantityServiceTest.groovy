package io.reactivesw.order.cart.application.service.update

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.order.cart.application.model.action.SetLineItemQuantity
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/16.
 */
class SetLineItemQuantityServiceTest extends Specification {


    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 1;

    def lineItemId = "tmpLineItemId"

    CartEntity cartEntity

    SetLineItemQuantity setLineItemQuantity

    SetLineItemQuantityService setLineItemQuantityService

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, productId: productId, variant: variantId, quantity: 5, supplyChannel: supplyChannel, distributionChannel: distributionChannel)
        lineItems.add(lineItem)

        cartEntity = new CartEntity(customerId: customerId, anonymousId: anonymousId, id: cartId, lineItems: lineItems)

        setLineItemQuantity = new SetLineItemQuantity(lineItemId: lineItemId, quantity: quantity)

        setLineItemQuantityService = new SetLineItemQuantityService()
    }

    def "Test 1.1: Set quantity of an exist line item"() {
        when:
        setLineItemQuantityService.handle(cartEntity, setLineItemQuantity)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: Set quantity of an non-existing line item"() {
        SetLineItemQuantity fakeAction = new SetLineItemQuantity(lineItemId: "FakeLineItemId", quantity: quantity)
        when:
        setLineItemQuantityService.handle(cartEntity, fakeAction)
        then:
        thrown(NotExistException)
    }
}
