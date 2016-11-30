package io.reactivesw.orders.carts.infrastructures.enums;

/**
 * Created by umasuo on 16/11/17.
 */
public enum AnonymousCartSignInMode {

  /**
   * LineItems of the anonymous carts will be copied to the customer’s carts. The CartState of the
   * anonymous carts gets changed to Merged while the CartState of the customer’s carts remains
   * Active. CustomLineItems and CustomFields of the anonymous carts will not be copied to the
   * customers carts. If a LineItem in the anonymous carts matches an existing line item in the
   * customer’s carts (same product ID and variant ID), the maximum quantity of both LineItems is
   * used as the new quantity. In that case CustomFields on the LineItem of the anonymous carts will
   * not be in the resulting LineItem.
   */
  MergeWithExistingCustomerCart,

  /**
   * The anonymous carts is used as new active customer carts. No LineItems get merged.
   */
  UseAsNewActiveCustomerCart;
}
