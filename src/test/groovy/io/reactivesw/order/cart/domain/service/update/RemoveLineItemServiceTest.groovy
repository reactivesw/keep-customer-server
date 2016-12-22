package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.order.cart.application.model.action.RemoveLineItem
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.CustomLineItemValue
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import io.reactivesw.order.cart.domain.entity.value.ProductVariantValue
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue
import io.reactivesw.order.cart.domain.entity.value.ShippingRateValue
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class RemoveLineItemServiceTest extends Specification {

    RecalculateService recalculateService = Mock(RecalculateService)

    RemoveLineItemService service

    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 5

    def lineItemId = "tmpLineItemId"

    def version = 1

    CartEntity cartEntity

    List<UpdateAction> actions

    RemoveLineItem removeLineItem

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, quantity: quantity, supplyChannel: supplyChannel, distributionChannel: distributionChannel, productId: productId)
        lineItem.setVariant(new ProductVariantValue(id: variantId))
        lineItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        lineItems.add(lineItem)


        Set<CustomLineItemValue> customItems = new HashSet()
        CustomLineItemValue customItem = new CustomLineItemValue()
        customItem.setMoney(new MoneyEntity("RMB", 12))
        customItem.setQuantity(5)
        customItems.add(customItem)

        ShippingInfoValue shippingInfoValue = new ShippingInfoValue(price: new MoneyEntity("RMB", 12), shippingRate: new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120)), taxRate: new TaxRateValue(amount: 0.1, includedInPrice: false))

        cartEntity = new CartEntity(id: cartId, version: version, lineItems: lineItems, customLineItems: customItems, shippingInfo: shippingInfoValue)

        removeLineItem = new RemoveLineItem(lineItemId: lineItemId, quantity: quantity)

        service = new RemoveLineItemService(recalculateService: recalculateService)
    }

    def "Test 1.1: Remove line item"() {

        when:
        service.handle(cartEntity, removeLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: Remove line item that not exist"() {

        removeLineItem.setLineItemId("fackId")
        when:
        service.handle(cartEntity, removeLineItem)
        then:
        thrown(NotExistException)
    }

    def "Test 1.3: Remove line item for reduce quantity"() {

        removeLineItem.setQuantity(quantity - 1)
        when:
        service.handle(cartEntity, removeLineItem)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: Remove line item with null quantity"() {

        removeLineItem.setQuantity(null)
        when:
        service.handle(cartEntity, removeLineItem)
        then:
        noExceptionThrown()
    }
}
