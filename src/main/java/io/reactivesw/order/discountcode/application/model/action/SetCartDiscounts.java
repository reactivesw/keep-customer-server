package io.reactivesw.order.discountcode.application.model.action;

import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;

import java.util.List;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetCartDiscounts implements UpdateAction {

  /**
   * Array of Reference to a CartDiscount - Required
   */
  private List<Reference> cartDiscounts;

  /**
   * Gets cart discounts.
   *
   * @return the cart discounts
   */
  public List<Reference> getCartDiscounts() {
    return cartDiscounts;
  }

  /**
   * Sets cart discounts.
   *
   * @param cartDiscounts the cart discounts
   */
  public void setCartDiscounts(List<Reference> cartDiscounts) {
    this.cartDiscounts = cartDiscounts;
  }
}
