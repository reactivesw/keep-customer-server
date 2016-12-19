package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.model.Address
import io.reactivesw.order.cart.application.model.action.SetCustomerEmail
import io.reactivesw.order.cart.application.model.action.SetShippingAddress
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.ShippingAddressValue
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

    ShippingAddressValue addressValue

    def setup() {

        addressValue = new ShippingAddressValue(id: addressId)

        cartEntity = new CartEntity(id: cartId, version: version, shippingAddress: addressValue)

        address = new Address()

        setShippingAddress = new SetShippingAddress(address: address)

        service = new SetShippingAddressService()


    }

    def "Test 1.1: set a new shipping address"() {
        cartEntity.setShippingAddress(null)
        when:
        service.handle(cartEntity, setShippingAddress)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: remove shipping address"() {
        setShippingAddress.setAddress(null)
        when:
        service.handle(cartEntity, setShippingAddress)
        then:
        noExceptionThrown()
    }

    def "Test 1.3: update shipping address"() {
        cartEntity.setShippingAddress(addressValue)
        when:
        service.handle(cartEntity, setShippingAddress)
        then:
        noExceptionThrown()
    }
}
