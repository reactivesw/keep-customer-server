package io.reactivesw.orders.discountcodes.infrastructures.enums;

/**
 * Values of the DiscountCodeState enumeration:
 * Created by umasuo on 16/11/17.
 */
public enum DiscountCodeState {


  /**
   * The discount code is not active or it does not contain any active and valid carts discounts.
   */
  NotActive,

  /**
   * The discount code is active and it contains at least one active and valid CartDiscount. But its
   * carts predicate does not match the carts or none of the contained active discount’s carts
   * predicates match the carts
   */
  DoesNotMatchCart,

  /**
   * The discount code is active and it contains at least one active and valid CartDiscount. The
   * discount code cartPredicate matches the carts and at least one of the contained active
   * discount’s carts predicates matches the carts.
   */
  MatchesCart,

  /**
   * maxApplications or maxApplicationsPerCustomer for discountCode has been reached.
   */
  MaxApplicationReached

}
