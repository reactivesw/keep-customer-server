package io.reactivesw.order.cart.application.service.update

import io.reactivesw.customer.customer.application.model.Address
import io.reactivesw.order.cart.application.model.action.SetBillingAddress
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetBillingAddressServiceTest extends Specification {

    SetBillingAddressService service

    def addressId = "tmpBillingAddressId"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetBillingAddress setBillingAddress

    Address address


    def setup() {


        cartEntity = new CartEntity(id: cartId, version: version, billingAddress: addressId)

        address = new Address(id: addressId)

        setBillingAddress = new SetBillingAddress(addressId: addressId)

        service = new SetBillingAddressService()

    }

    def "Test 1.1: set new billing address"() {

        when:
        service.handle(cartEntity, setBillingAddress)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: remove billing address"() {

        setBillingAddress.setAddressId(null)
        when:
        service.handle(cartEntity, setBillingAddress)
        then:
        noExceptionThrown()
    }
}
