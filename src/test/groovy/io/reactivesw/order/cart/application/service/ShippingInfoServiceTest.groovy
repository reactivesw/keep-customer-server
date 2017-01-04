package io.reactivesw.order.cart.application.service

import io.reactivesw.catalog.taxcategory.application.model.TaxRate
import io.reactivesw.common.model.Money
import io.reactivesw.common.model.Reference
import io.reactivesw.order.cart.application.model.ShippingInfo
import io.reactivesw.order.shippingmethod.application.model.ShippingRate
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/14.
 */
class ShippingInfoServiceTest extends Specification {

    ShippingInfoService shippingInfoService

    ShippingInfo shippingInfo

    ShippingRate shippingRate

    Money price

    Money freeAbove

    TaxRate taxRate

    def amount = 0.5

    def country = "CN"

    def currencyCode = "RMB"

    def includedInPrice = false

    def shippingMethodId = "tmpShippingMethodId"


    def setup() {
        shippingInfoService = new ShippingInfoService()
        taxRate = new TaxRate(amount: amount, country: country, includedInPrice: includedInPrice)

        price = new Money(currencyCode: currencyCode, centAmount: 10)

        freeAbove = new Money(currencyCode: currencyCode, centAmount: 100)

        shippingRate = new ShippingRate(price: price, freeAbove: freeAbove)

        shippingInfo = new ShippingInfo(shippingMethod: new Reference(id: shippingMethodId), taxRate: taxRate, shippingRate: shippingRate)
    }

    def "Test 1.1: Calculate price"() {
        when:
        shippingInfoService.calculateShippingPrice(shippingInfo, currencyCode, 10)
        then:
        noExceptionThrown()
        shippingInfo.getPrice().getCentAmount() == 10
    }

    def "Test 1.2: Calculate price that over free above amount"() {
        when:
        shippingInfoService.calculateShippingPrice(shippingInfo, currencyCode, 1000)
        then:
        noExceptionThrown()
        shippingInfo.getPrice().getCentAmount() == 0
    }

    def "Test 1.3: Calculate price and included in tax"() {
        taxRate.setIncludedInPrice(true)
        when:
        shippingInfoService.calculateShippingPrice(shippingInfo, currencyCode, 10)
        then:
        noExceptionThrown()
        shippingInfo.getPrice().getCentAmount() == 15
    }

    def "Test 1.4: Calculate price with tax rate not set"() {
        shippingInfo.setTaxRate(null)
        when:
        shippingInfoService.calculateShippingPrice(shippingInfo, currencyCode, 10)
        then:
        noExceptionThrown()
        shippingInfo.getPrice().getCentAmount() == 10
    }

    def "Test 1.5: Calculate price with free above not set"() {
        shippingRate.setFreeAbove(null)
        when:
        shippingInfoService.calculateShippingPrice(shippingInfo, currencyCode, 10)
        then:
        noExceptionThrown()
        shippingInfo.getPrice().getCentAmount() == 10
    }

}
