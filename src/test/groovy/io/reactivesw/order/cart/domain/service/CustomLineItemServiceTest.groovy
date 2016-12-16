package io.reactivesw.order.cart.domain.service

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.order.cart.domain.entity.value.CustomLineItemValue
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue
import io.reactivesw.order.cart.domain.entity.value.TaxedItemPriceValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/14.
 */
class CustomLineItemServiceTest extends Specification {

    CustomLineItemService customLineItemService

    TaxedItemPriceService taxedItemPriceService

    MoneyEntity money


    CustomLineItemValue customLineItemValue

    TaxRateValue taxRateValue

    def setup() {
        taxedItemPriceService = new TaxedItemPriceService()
        customLineItemService = new CustomLineItemService(taxedItemPriceService: taxedItemPriceService)
        money = new MoneyEntity(currencyCode: "RMB", centAmount: 12)
        taxRateValue = new TaxRateValue(includedInPrice: false, amount: 0.1,)
        customLineItemValue = new CustomLineItemValue(money: money, quantity: 10, taxRate: taxRateValue)
    }

    def "Test 1.1: Calculate Total Price."() {

        when:
        customLineItemService.calculateTotalPrice(customLineItemValue)
        then:
        customLineItemValue.getTotalPrice() != null
        customLineItemValue.getTotalPrice().getCentAmount() == 120

    }

    def "Test 1.2: Calculate Total Price with taxed."() {

        customLineItemValue.getTaxRate().setIncludedInPrice(true)
        when:
        customLineItemService.calculateTotalPrice(customLineItemValue)
        then:
        customLineItemValue.getTotalPrice() != null
        customLineItemValue.getTotalPrice().getCentAmount() == 132

    }

    def "Test 1.3: Calculate Total Price with out tax rate."() {

        customLineItemValue.setTaxRate(null)
        when:
        customLineItemService.calculateTotalPrice(customLineItemValue)
        then:
        customLineItemValue.getTotalPrice() != null
        customLineItemValue.getTotalPrice().getCentAmount() == 120

    }

    def "Test 2.1: Calculate taxed price at first time."() {
        customLineItemValue.setTaxedPrice(null)
        when:
        customLineItemService.calculateTaxedPrice(customLineItemValue)
        then:
        customLineItemValue.getTaxedPrice() != null
        customLineItemValue.getTaxedPrice().getTotalNet().getCentAmount() == 120
        customLineItemValue.getTaxedPrice().getTotalGross().getCentAmount() == 132
    }

    def "Test 2.2: Calculate taxed price."() {


        MoneyEntity net = new MoneyEntity();
        net.setCurrencyCode("RMB");
        MoneyEntity gross = new MoneyEntity();
        gross.setCurrencyCode("RMB");
        TaxedItemPriceValue taxedItemPrice = new TaxedItemPriceValue(totalNet: net, totalGross: gross)

        customLineItemValue.setTaxedPrice(taxedItemPrice);

        when:
        customLineItemService.calculateTaxedPrice(customLineItemValue)
        then:
        customLineItemValue.getTaxedPrice() != null
        customLineItemValue.getTaxedPrice().getTotalNet().getCentAmount() == 120
        customLineItemValue.getTaxedPrice().getTotalGross().getCentAmount() == 132
    }
}
