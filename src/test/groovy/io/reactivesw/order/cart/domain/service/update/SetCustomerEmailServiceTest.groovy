package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.order.cart.application.model.action.RemoveLineItem
import io.reactivesw.order.cart.application.model.action.SetCustomerEmail
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
class SetCustomerEmailServiceTest extends Specification {

    SetCustomerEmailService service

    def customerEmail = "test@test.com"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetCustomerEmail setCustomerEmail

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version, customerEmail: customerEmail)

        setCustomerEmail = new SetCustomerEmail(email: customerEmail)

        service = new SetCustomerEmailService()
    }

    def "Test 1.1: set customer email to an new one"() {
        when:
        service.handle(cartEntity, setCustomerEmail)
        then:
        noExceptionThrown()
        cartEntity.getCustomerEmail() == customerEmail
    }

    def "Test 1.2: set customer email to null"() {
        setCustomerEmail.setEmail(null)
        when:
        service.handle(cartEntity, setCustomerEmail)
        then:
        noExceptionThrown()
        cartEntity.getCustomerEmail() == null
    }
}
