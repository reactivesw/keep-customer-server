package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * Sets the customer ID of the cart.
 * When the customer ID is set, the LineItem prices are updated.(for customer may be in an
 * customer group)
 * <p>
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomerId {

  /**
   * customer id.
   * If set, a customer with the given ID must exist in the project.
   */
  private String customerId;
}
