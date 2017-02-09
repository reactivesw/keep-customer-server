package io.reactivesw.order.order

import com.google.common.collect.Lists
import io.reactivesw.catalog.product.application.model.ProductVariant
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.Money
import io.reactivesw.order.cart.application.model.Cart
import io.reactivesw.order.cart.application.model.LineItem
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
        LineItem lineItem = new LineItem()
        lineItem.totalPrice = new Money("USD", 10000)
        lineItem.productVariant = new ProductVariant(sku: "skuName")
        cart.lineItems = Lists.newArrayList(lineItem)
        orderRestClient.getCart(_, _) >> cart
        orderRestClient.checkout(_,_, _) >> new Payment()
        orderRepository.save(_) >> new OrderEntity()

        when:
        orderService.createOrderFromCart(draft)

        then:
        true
    }

    def "test 2.1 : get order by id"() {
        given:
        def orderId = "orderId"
        OrderEntity orderEntity = new OrderEntity()
        orderRepository.findOne(orderId) >> orderEntity

        when:
        def result = orderService.getOrderById(orderId)

        then:
        result != null
    }

    def "test 2.2 : get order by id and find null entity"() {
        given:
        def orderId = "orderId"
        orderRepository.findOne(orderId) >> null

        when:
        def result = orderService.getOrderById(orderId)

        then:
        thrown(NotExistException)
    }
}
