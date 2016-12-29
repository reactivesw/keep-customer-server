package io.reactivesw.order.discountcode.application.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetCartPredicate implements UpdateAction {

  /**
   * If the cartPredicate parameter is not included, the field will be emptied.
   */
  private String cartPredicate;

  /**
   * Gets cart predicate.
   *
   * @return the cart predicate
   */
  public String getCartPredicate() {
    return cartPredicate;
  }

  /**
   * Sets cart predicate.
   *
   * @param cartPredicate the cart predicate
   */
  public void setCartPredicate(String cartPredicate) {
    this.cartPredicate = cartPredicate;
  }

  @Override
  public String getActionName() {
    return null;
  }
}
