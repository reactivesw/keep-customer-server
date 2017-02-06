package io.reactivesw.order.order

import io.reactivesw.order.order.application.model.OrderFromCartDraft
import io.reactivesw.order.order.domain.service.OrderService
import io.reactivesw.order.order.infrastructure.repository.OrderRepository
import spock.lang.Specification

/**
 * Created by Davis on 17/2/6.
 */
class OrderServiceTest extends Specification {
    OrderRepository orderRepository = Mock()
    OrderService orderService = new OrderService()

    def "test 1 : create order from cart"() {
        given:
        OrderFromCartDraft draft = new OrderFromCartDraft()

        when:
        orderService.createOrderFromCart(draft)

        then:
        true
    }
}
