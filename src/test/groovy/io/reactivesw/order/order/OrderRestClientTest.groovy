package io.reactivesw.order.order

import io.reactivesw.order.cart.application.model.Cart
import io.reactivesw.order.order.application.service.OrderRestClient
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Davis on 17/2/6.
 */
class OrderRestClientTest extends Specification {
    RestTemplate restTemplate = Mock()
    OrderRestClient orderRestClient = new OrderRestClient(restTemplate: restTemplate)

    def "test 1 : getCart"() {
        given:
        def cartId = "dsfsd"
        def version = 1
        Cart cart = new Cart(version: version)
        restTemplate.getForObject(_,_) >> cart

        when:
        orderRestClient.getCart(cartId, version)

        then:
        true
    }

    def "test 2 : checkout"() {
        given:
        Integer centAmount = Integer.valueOf("10000")
        def token = "payment-token"
        def customerId = "customerId"

        when:
        orderRestClient.checkout(customerId, centAmount, token)

        then:
        true
    }

    def "test 3 : changeInventoryEntry"() {
        given:

        when:
        orderRestClient.changeInventoryEntry()

        then:
        true
    }
}
