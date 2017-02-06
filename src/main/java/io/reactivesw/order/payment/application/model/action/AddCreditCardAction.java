package io.reactivesw.order.payment.application.model.action;

import io.reactivesw.order.payment.application.model.CreditCard;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 17/2/3.
 */
@Getter
@Setter
public class AddCreditCardAction {
  /**
   * The Action.
   */
  private String action;

  /**
   * The Credit cart.
   */
  private CreditCard creditCart;
}