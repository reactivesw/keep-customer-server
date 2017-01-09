package io.reactivesw.order.order.infrastructure.enums;

/**
 * Values of the PaymentState enumeration.
 * Created by Davis on 16/11/17.
 */
public enum PaymentState {

  /**
   * Balance due payment state.
   */
  BalanceDue,
  /**
   * Failed payment state.
   */
  Failed,
  /**
   * Pending payment state.
   */
  Pending,
  /**
   * Credit owed payment state.
   */
  CreditOwed,
  /**
   * Paid payment state.
   */
  Paid;

}
