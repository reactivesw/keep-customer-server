package io.reactivesw.orders.discountcodes.applications.models.updateactions;

import io.reactivesw.common.models.UpdateAction;
import io.reactivesw.orders.carts.applications.models.CartPredicate;

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
