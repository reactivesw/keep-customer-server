package io.reactivesw.order.cartdiscount.application.model.action;

import lombok.Data;

/**
 * Created by umasuo on 16/12/22.
 */
@Data
public class SetRequiresDiscountCode implements CartDiscountUpdateAction {

  /**
   * if requires a discount code.
   */
  private Boolean requiresDiscountCode;
}
