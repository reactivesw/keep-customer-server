package io.reactivesw.order.order.domain.service;

import io.reactivesw.common.model.Money;
import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.order.application.model.Order;
import io.reactivesw.order.order.application.model.OrderFromCartDraft;
import io.reactivesw.order.order.application.model.mapper.OrderMapper;
import io.reactivesw.order.order.application.service.OrderRestClient;
import io.reactivesw.order.order.domain.entity.OrderEntity;
import io.reactivesw.order.order.infrastructure.repository.OrderRepository;
import io.reactivesw.order.payment.application.model.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/2/6.
 */
@Service
public class OrderService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

  /**
   * order rest client.
   */
  @Autowired
  private transient OrderRestClient orderRestClient;

  /**
   * order repository.
   */
  @Autowired
  private transient OrderRepository orderRepository;

  /**
   * Create order from cart order.
   *
   * @param draft the draft
   * @return the order
   */
  public Order createOrderFromCart(OrderFromCartDraft draft) {
    LOG.debug("enter createOrderFromCart, draft is : {}", draft.toString());

    String cartId = draft.getId();
    Integer version = draft.getVersion();
    Cart cart = orderRestClient.getCart(cartId, version);

    Money amount = cart.getTotalPrice();
    Payment payment = orderRestClient.checkout(amount.getCentAmount(), draft
        .getPaymentMethodToken());

    // TODO: 17/2/6 change inventory

    OrderEntity entity = OrderMapper.of(cart, payment);
    OrderEntity savedEntity = orderRepository.save(entity);

    Order result = OrderMapper.entityToModel(savedEntity);

    LOG.debug("end createOrderFromCart, result is : {}", result);
    return result;
  }
}
