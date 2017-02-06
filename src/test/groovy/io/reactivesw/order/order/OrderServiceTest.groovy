package io.reactivesw.order.order

import io.reactivesw.common.model.Money
import io.reactivesw.order.cart.application.model.Cart
import io.reactivesw.order.order.application.model.OrderFromCartDraft
import io.reactivesw.order.order.application.service.OrderRestClient
import io.reactivesw.order.order.domain.entity.OrderEntity
import io.reactivesw.order.order.domain.service.OrderService
import io.reactivesw.order.order.infrastructure.repository.OrderRepository
import io.reactivesw.order.payment.application.model.Payment
import spock.lang.Specification

/**
 * Created by Davis on 17/2/6.
 */
class OrderServiceTest extends Specification {
    OrderRepository orderRepository = Mock()
    OrderRestClient orderRestClient = Mock()
    OrderService orderService = new OrderService(orderRestClient: orderRestClient, orderRepository:  orderRepository)

    def "test 1 : create order from cart"() {
        given:
        OrderFromCartDraft draft = new OrderFromCartDraft()
        draft.setId("cartId")
        draft.setPaymentMethodToken("payment-token")
        Cart cart = new Cart()
        cart.setTotalPrice(new Money("USD", 1000))
        orderRestClient.getCart(_, _) >> cart
        orderRestClient.checkout(_, _) >> new Payment()
        orderRepository.save(_) >> new OrderEntity()

        when:
        orderService.createOrderFromCart(draft)

        then:
        true
    }
}
