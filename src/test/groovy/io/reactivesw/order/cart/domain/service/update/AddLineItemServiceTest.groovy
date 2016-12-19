package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.model.Reference
import io.reactivesw.order.cart.application.model.action.AddLineItem
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import io.reactivesw.order.cart.domain.entity.value.ProductVariantValue
import io.reactivesw.order.cart.domain.service.LineItemService
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/16.
 */
class AddLineItemServiceTest extends Specification {


    LineItemService lineItemService = Mock(LineItemService)


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
        LineItemValue lineItem = new LineItemValue(id: lineItemId, quantity: 5, supplyChannel: supplyChannel, distributionChannel: distributionChannel, productId: productId)
        lineItem.setVariant(new ProductVariantValue(id: variantId))
        lineItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        lineItems.add(lineItem)

        cartEntity = new CartEntity(customerId: customerId, anonymousId: anonymousId, id: cartId, lineItems: lineItems)

        addLineItem = new AddLineItem(productId: productId, variantId: variantId, quantity: quantity, supplyChannel: new Reference(id: supplyChannel), distributionChannel: new Reference(id: distributionChannel))

        RecalculateService recalculateService = Mock(RecalculateService)

        addLineItemService = new AddLineItemService(recalculateService: recalculateService, lineItemService: lineItemService)
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
}
