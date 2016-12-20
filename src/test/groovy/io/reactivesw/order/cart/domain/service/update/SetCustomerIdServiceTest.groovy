package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.exception.ImmutableException
import io.reactivesw.order.cart.application.model.action.SetCustomerEmail
import io.reactivesw.order.cart.application.model.action.SetCustomerId
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.infrastructure.repository.CartRepository
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetCustomerIdServiceTest extends Specification {

    CartRepository cartRepository = Mock(CartRepository)

    SetCustomerIdService service

    def customerId = "tmpCustomerId"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetCustomerId setCustomerId

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version, customerId: customerId)

        setCustomerId = new SetCustomerId(customerId: customerId)

        service = new SetCustomerIdService(cartRepository: cartRepository)
    }

    def "Test 1.1: set customer id"() {

        List<CartEntity> carts = new ArrayList<>()
        carts.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(_, _) >> carts
        service.handle(cartEntity, setCustomerId)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: set customer id with null customer id"() {

        List<CartEntity> carts = new ArrayList<>()
        carts.add(cartEntity)
        setCustomerId.setCustomerId(null)
        when:
        cartRepository.findByCustomerIdAndCartState(_, _) >> carts
        service.handle(cartEntity, setCustomerId)
        then:
        thrown(ImmutableException)
    }

    def "Test 1.3: set customer id with not exist cart"() {

        List<CartEntity> carts = new ArrayList<>()
        when:
        cartRepository.findByCustomerIdAndCartState(_, _) >> carts
        service.handle(cartEntity, setCustomerId)
        then:
        noExceptionThrown()
    }
}
