package io.reactivesw.order.cart.domain.service

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue
import io.reactivesw.order.cart.domain.entity.value.ShippingRateValue
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/14.
 */
class ShippingInfoServiceTest extends Specification {

    ShippingInfoService shippingInfoService

    ShippingInfoValue shippingInfoValue

    MoneyEntity price

    ShippingRateValue shippingRateValue

    TaxRateValue taxRateValue

    def setup() {
        shippingInfoService = new ShippingInfoService()

        price = new MoneyEntity("RMB", 12)
        shippingRateValue = new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120))
        taxRateValue = new TaxRateValue(amount: 0.1, includedInPrice: false)
        shippingInfoValue = new ShippingInfoValue(price: price, shippingRate: shippingRateValue, taxRate: taxRateValue)
    }

    def "Test 1.1: Calculate total price at first time"() {
        shippingInfoValue.setPrice(null)
        when:
        shippingInfoService.calculateTotalPrice(shippingInfoValue, 100)
        then:
        noExceptionThrown()
        shippingInfoValue.getPrice().getCentAmount() == 12
    }

    def "Test 1.2: Calculate total price with free acount"() {
        shippingInfoValue.setPrice(null)
        when:
        shippingInfoService.calculateTotalPrice(shippingInfoValue, 130)
        then:
        noExceptionThrown()
        shippingInfoValue.getPrice().getCentAmount() == 0
    }

    def "Test 1.3: Calculate total price with tax"() {
        shippingInfoValue.setPrice(price)
        shippingInfoValue.getTaxRate().setIncludedInPrice(true)
        when:
        shippingInfoService.calculateTotalPrice(shippingInfoValue, 100)
        then:
        noExceptionThrown()
        shippingInfoValue.getPrice().getCentAmount() == 13
    }
}
