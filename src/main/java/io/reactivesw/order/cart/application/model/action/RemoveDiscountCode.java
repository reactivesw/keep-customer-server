package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Removes a discount code from the cart.
 * Created by umasuo on 16/12/15.
 */
@Data
public class RemoveDiscountCode implements UpdateAction {

  /**
   * discount code.
   */
  private String code;
}
