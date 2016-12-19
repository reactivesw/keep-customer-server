package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class RemovePayment implements UpdateAction {

  /**
   * reference to an payment.
   */
  private String payment;
}
