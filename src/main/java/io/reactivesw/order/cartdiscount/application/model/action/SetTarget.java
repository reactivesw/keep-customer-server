package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.order.cartdiscount.application.model.CartDiscountTarget;
import lombok.Data;

/**
 * Created by umasuo on 16/12/21.
 */
@Data
public class SetTarget implements CartDiscountUpdateAction {

  /**
   * discount target.
   */
  private CartDiscountTarget target;
}
