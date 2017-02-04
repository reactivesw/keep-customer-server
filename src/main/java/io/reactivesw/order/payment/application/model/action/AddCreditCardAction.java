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
  String action;
  String customerId;
  CreditCard creditCart;
}