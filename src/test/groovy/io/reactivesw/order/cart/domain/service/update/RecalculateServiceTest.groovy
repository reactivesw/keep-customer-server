package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.order.cart.application.model.action.Recalculate
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.CustomLineItemValue
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import io.reactivesw.order.cart.domain.entity.value.ProductVariantValue
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue
import io.reactivesw.order.cart.domain.entity.value.ShippingRateValue
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue
import io.reactivesw.order.cart.domain.service.CustomLineItemService
import io.reactivesw.order.cart.domain.service.LineItemService
import io.reactivesw.order.cart.domain.service.ShippingInfoService
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class RecalculateServiceTest extends Specification {

    LineItemService lineItemService = Mock(LineItemService)

    CustomLineItemService customLineItemService = Mock(CustomLineItemService)

    ShippingInfoService shippingInfoService = Mock(ShippingInfoService)

    RecalculateService recalculateService

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

    Recalculate recalculate = Mock(Recalculate)

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, quantity: quantity, totalPrice: new MoneyEntity(centAmount: 100, currencyCode: "RMB"), supplyChannel: supplyChannel, distributionChannel: distributionChannel, productId: productId)
        lineItem.setVariant(new ProductVariantValue(id: variantId))
        lineItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        lineItems.add(lineItem)


        Set<CustomLineItemValue> customItems = new HashSet()
        CustomLineItemValue customItem = new CustomLineItemValue()
        customItem.setMoney(new MoneyEntity("RMB", 12))
        customItem.setQuantity(5)
        customItems.add(customItem)

        ShippingInfoValue shippingInfoValue = new ShippingInfoValue(price: new MoneyEntity("RMB", 12), shippingRate: new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120)), taxRate: new TaxRateValue(amount: 0.1, includedInPrice: false))

        cartEntity = new CartEntity(customerId: customerId, anonymousId: anonymousId, id: cartId, version: version, lineItems: lineItems, customLineItems: customItems, shippingInfo: shippingInfoValue)


        recalculateService = new RecalculateService(lineItemService: lineItemService, shippingInfoService: shippingInfoService)
    }

    def "Test 1.1: Recalculate"() {
        when:
        recalculateService.handle(cartEntity, recalculate)
        then:
        noExceptionThrown()
    }


    def "Test 1.2: Recalculate"() {
        cartEntity.setTotalPrice(new MoneyEntity("RMB", 120))
        when:
        recalculateService.handle(cartEntity, recalculate)
        then:
        noExceptionThrown()
    }
}
