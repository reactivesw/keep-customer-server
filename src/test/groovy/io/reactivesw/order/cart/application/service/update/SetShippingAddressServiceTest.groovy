package io.reactivesw.order.cart.application.service.update

import io.reactivesw.common.model.Address
import io.reactivesw.order.cart.application.model.action.SetShippingAddress
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetShippingAddressServiceTest extends Specification {

    SetShippingAddressService service

    def addressId = "tmpShippingAddressId"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetShippingAddress setShippingAddress

    Address address


    def setup() {


        cartEntity = new CartEntity(id: cartId, version: version, shippingAddress: addressId)

        address = new Address(id: addressId)

        setShippingAddress = new SetShippingAddress(addressId: addressId)

        service = new SetShippingAddressService()

    }

    def "Test 1.1: set new shipping address"() {

        when:
        service.handle(cartEntity, setShippingAddress)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: remove shipping address"() {

        setShippingAddress.setAddressId(null)
        when:
        service.handle(cartEntity, setShippingAddress)
        then:
        noExceptionThrown()
    }
}
