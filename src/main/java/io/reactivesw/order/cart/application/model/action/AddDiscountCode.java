package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * Adds a DiscountCode to the cart to enable the related CartDiscounts.
 * Created by umasuo on 16/12/15.
 */
@Data
public class AddDiscountCode {

  /**
   * The code of an existing DiscountCode.
   * this code must be an available code.
   */
  private String code;
}
