package io.reactivesw.order.order.domain.service;

import io.reactivesw.order.order.application.model.Order;
import io.reactivesw.order.order.application.model.OrderFromCartDraft;
import io.reactivesw.order.order.infrastructure.repository.OrderRepository;

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
   * order repository.
   */
//  @Autowired
//  private transient OrderRepository orderRepository;

  /**
   * Create order from cart order.
   *
   * @param draft the draft
   * @return the order
   */
  public Order createOrderFromCart(OrderFromCartDraft draft) {
    LOG.debug("enter createOrderFromCart, draft is : {}", draft.toString());
    Order result = new Order();

    return result;
  }
}
