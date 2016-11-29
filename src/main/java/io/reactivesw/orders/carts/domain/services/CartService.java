package io.reactivesw.orders.carts.domain.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivesw.orders.carts.common.repositories.CartRepository;
import io.reactivesw.orders.carts.domain.entities.CartEntity;

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
   * cart repository.
   */
  @Autowired
  private transient CartRepository cartRepository;

  /**
   * create an new cart with customer id.
   * this function should only be called by system, not by customer.
   */
  public CartEntity createCartWithCustomerId(String customerId) {
    CartEntity entity = new CartEntity();
    entity.setCustomerId(customerId);
    return cartRepository.save(entity);
  }

  /**
   * create an new cart with anonymous id.
   */
  public CartEntity createCartWithAnonymousId(String anonymousId) {
    CartEntity entity = new CartEntity();
    entity.setAnonymousId(anonymousId);
    return cartRepository.save(entity);
  }

  /**
   * get cart by cart id.
   */
  public CartEntity getCartByCartId(String id) {
    LOG.info("CartId:{}", id);
    return null;
  }

  /**
   * get cart by customer id.
   */
  public CartEntity getCartByCustomerId(String id) {
    return null;
  }


  /**
   * setter of the cart repository.
   * @param cartRepository
   */
  public void setCartRepository(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }
}
