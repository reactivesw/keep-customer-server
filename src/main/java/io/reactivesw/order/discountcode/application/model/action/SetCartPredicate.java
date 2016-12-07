package io.reactivesw.order.discountcode.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.CartPredicate;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetCartPredicate implements UpdateAction {

  /**
   * If the cartPredicate parameter is not included, the field will be emptied.
   */
  private CartPredicate cartPredicate;

  /**
   * Gets cart predicate.
   *
   * @return the cart predicate
   */
  public CartPredicate getCartPredicate() {
    return cartPredicate;
  }

  /**
   * Sets cart predicate.
   *
   * @param cartPredicate the cart predicate
   */
  public void setCartPredicate(CartPredicate cartPredicate) {
    this.cartPredicate = cartPredicate;
  }
}
