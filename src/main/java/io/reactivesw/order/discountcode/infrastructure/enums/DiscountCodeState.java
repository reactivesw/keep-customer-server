package io.reactivesw.order.discountcode.infrastructure.enums;

/**
 * Values of the DiscountCodeState enumeration:
 * Created by umasuo on 16/11/17.
 */
public enum DiscountCodeState {


  /**
   * The discount code is not active or it does not contain any active and valid cart discounts.
   */
  NotActive,

  /**
   * The discount code is active and it contains at least one active and valid CartDiscount. But its
   * cart predicate does not match the cart or none of the contained active discount’s cart
   * predicates match the cart
   */
  DoesNotMatchCart,

  /**
   * The discount code is active and it contains at least one active and valid CartDiscount. The
   * discount code cartPredicate matches the cart and at least one of the contained active
   * discount’s cart predicates matches the cart.
   */
  MatchesCart,

  /**
   * maxApplications or maxApplicationsPerCustomer for discountCode has been reached.
   */
  MaxApplicationReached

}
