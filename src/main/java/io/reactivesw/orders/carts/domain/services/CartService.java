package io.reactivesw.orders.carts.domain.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.reactivesw.orders.carts.applications.models.Cart;

/**
 * Created by umasuo on 16/11/29.
 */
@Service
public class CartService {
  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartService.class);


  /**
   * get cart by cart id.
   */
  public Cart getCartByCartId(String id) {
    LOG.info("CartId:{}", id);
    return null;
  }

  /**
   * get cart by customer id.
   */
  public Cart getCartByCustomerId(String id) {
    return null;
  }
}
