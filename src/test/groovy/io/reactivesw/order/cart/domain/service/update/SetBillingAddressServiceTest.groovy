package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.model.Address
import io.reactivesw.order.cart.application.model.action.SetBillingAddress
import io.reactivesw.order.cart.application.model.action.SetShippingAddress
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.BillingAddressValue
import io.reactivesw.order.cart.domain.entity.value.ShippingAddressValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetBillingAddressServiceTest extends Specification {

    SetBillingAddressService service

    def addressId = "tmpShippingAddressId"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetBillingAddress setBillingAddress

    Address address

    BillingAddressValue addressValue

    def setup() {

        addressValue = new BillingAddressValue(id: addressId)

        cartEntity = new CartEntity(id: cartId, version: version, billingAddress: addressValue)

        address = new Address()

        setBillingAddress = new SetBillingAddress(address: address)

        service = new SetBillingAddressService()

    }

    def "Test 1.1: set new billing address"() {

        when:
        service.handle(cartEntity, setBillingAddress)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: remove billing address"() {

        setBillingAddress.setAddress(null)
        when:
        service.handle(cartEntity, setBillingAddress)
        then:
        noExceptionThrown()
    }
}
