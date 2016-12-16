package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.Reference;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class RemovePayment {

  /**
   * reference to an payment.
   */
  private Reference payment;
}
