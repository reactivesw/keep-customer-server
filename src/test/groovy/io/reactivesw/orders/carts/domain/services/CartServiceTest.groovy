package io.reactivesw.orders.carts.domain.services

import io.reactivesw.orders.carts.common.repositories.CartRepository
import io.reactivesw.orders.carts.domain.entities.CartEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/29.
 */
class CartServiceTest extends Specification {

    Logger LOG = LoggerFactory.getLogger(CartServiceTest)


    CartRepository cartRepository = Mock(CartRepository)

    CartService cartService = new CartService(cartRepository: cartRepository)

    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartEntity

    def setup() {
        LOG.info("init cart service test.")
        cartService.setCartRepository(cartRepository)
        cartEntity = new CartEntity(id: "id")
    }

    def "Create new cart by customerId"() {

        when:
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.createCartWithCustomerId(customerId)
        then:
        entity != null

    }

    def "Create new cart by anonymousId"() {

        when:
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.createCartWithAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Get cart by cart id"() {
        cartService.getCartByCartId("id")
        when:
        def a = 0
        then:
        a == 0
    }

    def "Get cart By customer id"() {
        cartService.getCartByCustomerId("id")
        when:
        def a = 0
        then:
        a == 0
    }


}
