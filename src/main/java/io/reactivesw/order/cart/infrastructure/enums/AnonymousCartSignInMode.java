package io.reactivesw.order.cart.infrastructure.enums;

/**
 * Created by umasuo on 16/11/17.
 */
public enum AnonymousCartSignInMode {

  /**
   * LineItems of the anonymous cart will be copied to the customer’s cart. The CartState of the
   * anonymous cart gets changed to Merged while the CartState of the customer’s cart remains
   * Active. CustomLineItems and CustomFields of the anonymous cart will not be copied to the
   * customer cart. If a LineItem in the anonymous cart matches an existing line item in the
   * customer’s cart (same product ID and variant ID), the maximum quantity of both LineItems is
   * used as the new quantity. In that case CustomFields on the LineItem of the anonymous cart will
   * not be in the resulting LineItem.
   */
  MergeWithExistingCustomerCart,

  /**
   * The anonymous cart is used as new active customer cart. No LineItems get merged.
   */
  UseAsNewActiveCustomerCart;
}
