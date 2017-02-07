package io.reactivesw.order.order.infrastructure.validator;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.order.cart.application.model.Cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Davis on 17/2/7.
 */
public final class CartValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartValidator.class);

  /**
   * Instantiates a new Cart version validator.
   */
  private CartValidator() {
  }


  /**
   * Validate cart version.
   *
   * @param cart    the cart
   * @param version the version
   */
  public static void validateVersion(Cart cart, Integer version) {
    if (!version.equals(cart.getVersion())) {
      LOG.debug("cart's version not match, expect version is : {}, response version is : {}",
          version, cart.getVersion());
      throw new ConflictException("Cart Version Not Match");
    }
  }
}
