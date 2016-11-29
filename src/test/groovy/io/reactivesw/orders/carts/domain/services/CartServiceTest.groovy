package io.reactivesw.orders.carts.domain.services

import io.reactivesw.orders.carts.common.repositories.CartRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/29.
 */
@SpringBootTest
@ContextConfiguration
class CartServiceTest extends Specification {

    Logger LOG = LoggerFactory.getLogger(CartServiceTest)

    @Autowired
    CartRepository cartRepository

    def cartService = new CartService()

    def setup(){
        LOG.info("init cart service test.")
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
