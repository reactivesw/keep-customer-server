package io.reactivesw.order.cart.domain.service

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue
import io.reactivesw.order.cart.domain.entity.value.TaxedItemPriceValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/13.
 */
class LineItemServiceTest extends Specification {

    LineItemService lineItemService

    PriceService priceService

    MoneyEntity moneyEntity

    PriceValue priceValue

    LineItemValue lineItemValue

    TaxRateValue taxRateValue

    def setup() {
        priceService = new PriceService()
        lineItemService = new LineItemService(priceService: priceService)
        moneyEntity = new MoneyEntity(currencyCode: "RMB", centAmount: 12)
        priceValue = new PriceValue(value: moneyEntity)
        taxRateValue = new TaxRateValue(includedInPrice: false, amount: 0.1,)
        lineItemValue = new LineItemValue(price: priceValue, quantity: 10, taxRate: taxRateValue)
    }

    def "Test 1.1: Fill product information."() {
        when:
        lineItemService.fillProduct(null)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: Calculate Total Price."() {

        when:
        lineItemService.calculateTotalPrice(lineItemValue)
        then:
        lineItemValue.getTotalPrice() != null
        lineItemValue.getTotalPrice().getCentAmount() == 120

    }

    def "Test 1.2: Calculate Total Price with taxed."() {

        lineItemValue.getTaxRate().setIncludedInPrice(true)
        when:
        lineItemService.calculateTotalPrice(lineItemValue)
        then:
        lineItemValue.getTotalPrice() != null
        lineItemValue.getTotalPrice().getCentAmount() == 132

    }

    def "Test 2.1: Calculate taxed price at first time."() {
        lineItemValue.setTaxedPrice(null)
        when:
        lineItemService.calculateTaxedPrice(lineItemValue)
        then:
        lineItemValue.getTaxedPrice() != null
        lineItemValue.getTaxedPrice().getTotalNet().getCentAmount() == 120
        lineItemValue.getTaxedPrice().getTotalGross().getCentAmount() == 132
    }

    def "Test 2.1: Calculate taxed price."() {


        MoneyEntity net = new MoneyEntity();
        net.setCurrencyCode("RMB");
        MoneyEntity gross = new MoneyEntity();
        gross.setCurrencyCode("RMB");
        TaxedItemPriceValue taxedItemPrice = new TaxedItemPriceValue(totalNet: net, totalGross: gross)

        lineItemValue.setTaxedPrice(taxedItemPrice);

        when:
        lineItemService.calculateTaxedPrice(lineItemValue)
        then:
        lineItemValue.getTaxedPrice() != null
        lineItemValue.getTaxedPrice().getTotalNet().getCentAmount() == 120
        lineItemValue.getTaxedPrice().getTotalGross().getCentAmount() == 132
    }
}
