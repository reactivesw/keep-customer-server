package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.Address;
import lombok.Data;

/**
 * Sets the shipping address of the cart.
 * Setting the shipping address also sets the TaxRate of the line items and calculates the
 * TaxedPrice.
 * If the address is not provided, the shipping address is unset, the taxedPrice is unset and the
 * taxRates are unset in all line items.
 * <p>
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetShippingAddress {
  /**
   * shipping address.
   */
  private Address address;
}
