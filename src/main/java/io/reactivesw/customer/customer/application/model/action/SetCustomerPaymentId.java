package io.reactivesw.customer.customer.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by umasuo on 16/12/8.
 */
@Getter
@Setter
public class SetCustomerPaymentId implements UpdateAction {

  /**
   * location.
   */
  private String paymentId;

  @Override
  public String getActionName() {
    return "SetCustomerPaymentId";
  }
}
