package io.reactivesw.order.cart.domain.service

import io.reactivesw.catalog.productdiscount.model.DiscountedPrice
import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.model.Reference
import io.reactivesw.common.model.mapper.MoneyMapper
import io.reactivesw.order.cart.domain.entity.value.PriceValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/13.
 */
class PriceServiceTest extends Specification {

    PriceService priceService

    PriceValue entity

    def id = "tmpPriceId"

    MoneyEntity value

    DiscountedPrice discountedPrice

    Reference reference

    def setup() {
        priceService = new PriceService()
        value = new MoneyEntity(centAmount: 12, currencyCode: "RMB")
        reference = new Reference(typeId: "typeId", id: "id")
        discountedPrice = new DiscountedPrice(value: MoneyMapper.convertEntityToModel(value), discount: reference)
        entity = new PriceValue(id: id, value: value, discounted: discountedPrice)

    }

    def "Test 1.1: Get price value"() {
        PriceValue price = new PriceValue(id: id, value: value)
        when:
        MoneyEntity result = priceService.getPriceValue(price)
        then:
        Objects.equals(result, value)
    }

    def "Test 1.2: Get discounted price value"() {
        when:
        MoneyEntity result = priceService.getPriceValue(entity)
        then:
        Objects.equals(result, value)
    }

}
