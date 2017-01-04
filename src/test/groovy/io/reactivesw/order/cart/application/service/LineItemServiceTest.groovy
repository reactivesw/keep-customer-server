package io.reactivesw.order.cart.application.service

import io.reactivesw.catalog.product.application.model.Price
import io.reactivesw.catalog.product.application.model.ProductVariant
import io.reactivesw.catalog.taxcategory.application.model.TaxRate
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.model.Money
import io.reactivesw.common.model.Reference
import io.reactivesw.order.cart.application.model.LineItem
import io.reactivesw.order.cart.application.service.LineItemService
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/3.
 */
class LineItemServiceTest extends Specification {

    LineItemService lineItemService

    LineItem lineItem

    def currencyCode = "RMB"

    def country = "CN"

    def amount = 100

    def channel = "tmpSupplyChannel"

    ProductVariant productVariant

    def variantId = 1

    Price price1

    Price price2

    TaxRate taxRate

    def taxAmount = 0.5;

    def quantity = 10;

    def setup() {
        lineItemService = new LineItemService()

        Money priceValue = new Money(centAmount: amount, currencyCode: currencyCode)
        Reference channel = new Reference(typeId: ReferenceTypes.CHANNEL, id: channel)
        price1 = new Price(value: priceValue, country: country, channel: channel)
        price2 = new Price(value: priceValue, country: country, channel: channel)
        List<Price> prices = new ArrayList<>()
        prices.add(price1)
//        prices.add(price2)
        productVariant = new ProductVariant(id: variantId, prices: prices)

        taxRate = new TaxRate(country: country, amount: taxAmount, includedInPrice: false)

        lineItem = new LineItem(productVariant: productVariant, taxRate: taxRate, quantity: 10)
    }

    def "Test 1.1: select item price"() {
        when:
        lineItemService.selectItemPrice(lineItem, currencyCode, country)
        then:
        lineItem.getPrice() != null
    }

    def "Test 1.2: select item price with wrong country"() {
        def fakeCountry = "fakeCountry"
        when:
        lineItemService.selectItemPrice(lineItem, currencyCode, fakeCountry)
        then:
        lineItem.getPrice() == null
    }

    def "Test 1.3: select item price with wrong currency code"() {
        def fakeCurrencyCode = "fakeCurrencyCode"
        when:
        lineItemService.selectItemPrice(lineItem, fakeCurrencyCode, null)
        then:
        lineItem.getPrice() == null
    }

    def "Test 2.1: calculate item total price"() {
        lineItem.setPrice(price1)
        when:
        lineItemService.calculateItemPrice(lineItem)
        then:
        lineItem.totalPrice != null
        lineItem.totalPrice.centAmount == 1000
        lineItem.getTaxedPrice() != null
    }

    def "Test 2.2: calculate item total price with tax included"() {
        lineItem.setPrice(price1)
        taxRate.setIncludedInPrice(true)
        when:
        lineItemService.calculateItemPrice(lineItem)
        then:
        lineItem.totalPrice != null
        lineItem.totalPrice.centAmount == 1500
        lineItem.getTaxedPrice() != null
    }

    def "Test 2.3: calculate item total price with Item price not set"() {
        lineItem.setPrice(null)
        when:
        lineItemService.calculateItemPrice(lineItem)
        then:
        lineItem.totalPrice == null
        lineItem.getTaxedPrice() == null
    }

    def "Test 2.4: calculate item total price with tax rate not set"() {
        lineItem.setPrice(price1)
        lineItem.setTaxRate(null)
        when:
        lineItemService.calculateItemPrice(lineItem)
        then:
        lineItem.totalPrice != null
        lineItem.getTaxedPrice() == null
    }

}
