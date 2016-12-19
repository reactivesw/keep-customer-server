package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.Money
import io.reactivesw.common.model.Reference
import io.reactivesw.order.cart.application.model.ExternalLineItemTotalPrice
import io.reactivesw.order.cart.application.model.action.AddLineItem
import io.reactivesw.order.cart.application.model.action.SetLineItemTotalPrice
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import io.reactivesw.order.cart.domain.entity.value.ProductVariantValue
import io.reactivesw.order.cart.domain.service.LineItemService
import io.reactivesw.order.cartdiscount.infrastructure.enums.LineItemPriceMode
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetLineItemTotalPriceServiceTest extends Specification {

    SetLineItemTotalPriceService service

    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def quantity = 5;

    def lineItemId = "tmpLineItemId"

    LineItemValue lineItem

    CartEntity cartEntity

    ExternalLineItemTotalPrice externalLineItemTotalPrice

    SetLineItemTotalPrice setLineItemTotalPrice

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        lineItem = new LineItemValue(id: lineItemId, quantity: quantity, priceMode: LineItemPriceMode.Platform, totalPrice: new MoneyEntity(centAmount: 60, currencyCode: "RMB"))
        lineItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        lineItems.add(lineItem)

        cartEntity = new CartEntity(customerId: customerId, anonymousId: anonymousId, id: cartId, lineItems: lineItems)

        externalLineItemTotalPrice = new ExternalLineItemTotalPrice(price: new Money(centAmount: 12, currencyCode: "RMB"), totalPrice: new Money(centAmount: 50, currencyCode: "RMB"))
        setLineItemTotalPrice = new SetLineItemTotalPrice(lineItemId: lineItemId, externalTotalPrice: externalLineItemTotalPrice)

        RecalculateService recalculateService = Mock(RecalculateService)

        service = new SetLineItemTotalPriceService(recalculateService: recalculateService)
    }

    def "Test 1.1: set total price"() {
        when:
        service.handle(cartEntity, setLineItemTotalPrice)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: set total price with non-exist item"() {
        setLineItemTotalPrice.setLineItemId("fakeId")
        when:
        service.handle(cartEntity, setLineItemTotalPrice)
        then:
        thrown(NotExistException)
    }

    def "Test 1.3: change price mode from ExternalTotal to Platform"() {
        lineItem.setPriceMode(LineItemPriceMode.ExternalTotal)
        setLineItemTotalPrice.getExternalTotalPrice().setTotalPrice(null)
        when:
        service.handle(cartEntity, setLineItemTotalPrice)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: set total price with externalTotalPrice"() {
        lineItem.setPriceMode(LineItemPriceMode.ExternalTotal)
        when:
        service.handle(cartEntity, setLineItemTotalPrice)
        then:
        noExceptionThrown()
    }

    def "Test 1.5: set total price with price"() {
        setLineItemTotalPrice.getExternalTotalPrice().setTotalPrice(null)
        when:
        service.handle(cartEntity, setLineItemTotalPrice)
        then:
        noExceptionThrown()
    }

}
