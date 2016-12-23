package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by umasuo on 16/12/22.
 */
@Data
public class SetRequiresDiscountCode implements UpdateAction {

  /**
   * if requires a discount code.
   */
  private Boolean requiresDiscountCode;
}
