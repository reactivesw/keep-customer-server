package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Sets the customer ID of the cart.
 * When the customer ID is set, the LineItem prices are updated.(for customer may be in an
 * customer group)
 * <p>
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomerId implements UpdateAction {

  /**
   * customer id.
   * If set, a customer with the given ID must exist in the project.
   */
  @NotNull
  private String customerId;
}
