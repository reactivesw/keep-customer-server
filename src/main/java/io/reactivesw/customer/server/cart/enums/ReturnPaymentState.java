package io.reactivesw.customer.server.cart.enums;

/**
 * Created by Davis on 16/11/17.
 */
public enum ReturnPaymentState {

  /**
   * Non refundable return payment state.
   */
  NonRefundable,
  /**
   * Initial return payment state.
   */
  Initial,
  /**
   * Refunded return payment state.
   */
  Refunded,
  /**
   * Not refunded return payment state.
   */
  NotRefunded;

}
