package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.order.cart.application.model.action.ChangeLineItemQuantity
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
class ChangeLineItemQuantityServiceTest extends Specification {

    RecalculateService recalculateService = Mock(RecalculateService)

    ChangeLineItemQuantityService service

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 5

    def lineItemId = "tmpLineItemId"

    def version = 1

    CartEntity cartEntity

    ChangeLineItemQuantity changeLineItemQuantity

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

        changeLineItemQuantity = new ChangeLineItemQuantity(lineItemId: lineItemId, quantity: quantity)

        service = new ChangeLineItemQuantityService(recalculateService: recalculateService)
    }

    def "Test 1.1: reduce line item quantity"() {
        changeLineItemQuantity.setQuantity(quantity - 1)
        when:
        service.handle(cartEntity, changeLineItemQuantity)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: add line item quantity"() {
        changeLineItemQuantity.setQuantity(quantity + 10)
        when:
        service.handle(cartEntity, changeLineItemQuantity)
        then:
        noExceptionThrown()
    }

    def "Test 1.3: remove item for quantity is less than 0"() {
        changeLineItemQuantity.setQuantity(0)
        when:
        service.handle(cartEntity, changeLineItemQuantity)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: remove item for quantity is null"() {
        changeLineItemQuantity.setQuantity(null)
        when:
        service.handle(cartEntity, changeLineItemQuantity)
        then:
        noExceptionThrown()
    }

    def "Test 1.5: change line item that not exist"() {
        changeLineItemQuantity.setLineItemId("fakeId")
        when:
        service.handle(cartEntity, changeLineItemQuantity)
        then:
        thrown(NotExistException)
    }
}
