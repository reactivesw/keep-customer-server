package io.reactivesw.order.cart.application.service.update

import io.reactivesw.common.model.Reference
import io.reactivesw.order.cart.application.model.action.AddLineItem
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/16.
 */
class AddLineItemServiceTest extends Specification {


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

    AddLineItem addLineItem

    AddLineItemService addLineItemService

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, productId: productId, variant: variantId, quantity: 5, supplyChannel: supplyChannel, distributionChannel: distributionChannel)
        lineItems.add(lineItem)

        cartEntity = new CartEntity(customerId: customerId, anonymousId: anonymousId, id: cartId, lineItems: lineItems)

        addLineItem = new AddLineItem(productId: productId, variantId: variantId, quantity: quantity, supplyChannel: new Reference(id: supplyChannel), distributionChannel: new Reference(id: distributionChannel))

        addLineItemService = new AddLineItemService()
    }

    def "Test 1.1: add LineItem to cart with non-existing items"() {
        Set<LineItemValue> lineItemValues = new HashSet<>()
        cartEntity.setLineItems(lineItemValues)

        when:
        addLineItemService.handle(cartEntity, addLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: add LineItem to cart with existing item"() {

        when:
        addLineItemService.handle(cartEntity, addLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.3: add LineItem to cart with existing product but variant not exit"() {
        addLineItem.setVariantId(123)
        when:
        addLineItemService.handle(cartEntity, addLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: add LineItem to cart with non-existing product"() {
        addLineItem.setProductId("fakeProductId")
        when:
        addLineItemService.handle(cartEntity, addLineItem)
        then:
        noExceptionThrown()
    }
}
