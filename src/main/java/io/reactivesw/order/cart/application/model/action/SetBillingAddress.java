package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetBillingAddress implements UpdateAction {

  /**
   * billing address.
   */
  private String addressId;
}
