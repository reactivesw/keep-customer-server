package io.reactivesw.order.payment.enums;

/**
 * Not all payment methods support all of the following defined model:
 * Created by umasuo on 16/11/17.
 */
public enum TransactionType {

  /**
   * A financially reliable reservation of the amount that does not yet trigger an actual money
   * transfer.
   */
  Authorization,

  /**
   * Explicit cancellation of an authorized amount before it is expiring.
   */
  CancelAuthorization,

  /**
   * Collection of money from the customer. Can use an authorized amount or be directly executed.
   */
  Charge,

  /**
   * Explicit transfer of money back to the customer.
   */
  Refund,

  /**
   * - Customer-triggered transfer of money back to the customer.
   */
  Chargeback;
}
