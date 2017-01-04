package io.reactivesw.order.cart.application.service.update

import io.reactivesw.order.cart.application.model.action.SetCustomerId
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetCustomerIdServiceTest extends Specification {

    SetCustomerIdService service

    def customerId = "tmpCustomerId"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetCustomerId setCustomerId

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version, customerId: customerId)

        setCustomerId = new SetCustomerId(customerId: customerId)

        service = new SetCustomerIdService()
    }

    def "Test 1.1: set customer id"() {
        when:
        service.handle(cartEntity, setCustomerId)
        then:
        noExceptionThrown()
    }

}