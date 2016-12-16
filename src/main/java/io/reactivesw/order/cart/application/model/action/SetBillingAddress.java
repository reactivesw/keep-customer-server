package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.Address;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetBillingAddress {

  /**
   * billing address.
   */
  private Address address;
}
