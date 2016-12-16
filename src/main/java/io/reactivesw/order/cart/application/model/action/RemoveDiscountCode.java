package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * Removes a discount code from the cart.
 * Created by umasuo on 16/12/15.
 */
@Data
public class RemoveDiscountCode {

  /**
   * discount code.
   */
  private String code;
}
