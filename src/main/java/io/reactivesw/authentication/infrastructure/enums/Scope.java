package io.reactivesw.authentication.infrastructure.enums;

/**
 * Created by umasuo on 16/11/21.
 */
public enum Scope {
  /**
   * Grants full access to the APIs for the specified merchant.
   */
  manageProject,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to product in a
   * merchant. Implies view_products for the same merchant.
   */
  manageProducts,

  /**
   * Grants access to the APIs for viewing anything related to product in a merchant.
   */
  viewProducts,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to order in a
   * merchant. Implies view_orders for the same merchant.
   */
  manageOrders,

  /**
   * Grants access to the APIs for viewing anything related to order in a merchant.
   */
  viewOrders,

  /**
   * If used with the password flow, grants access to the APIs for creating, modifying and viewing
   * order and cart of the customer to whom the access token was issued. If used with the tokens
   * for anonymous sessions, the access is granted for the order and cart of the anonymousId to
   * which the access token was issued.
   */
  manageMyOrders,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to customer in
   * a merchant. Implies view_customers for the same merchant.
   */
  manageCustomers,

  /**
   * Grants access to the APIs for viewing anything related to customer in a merchant.
   */
  viewCustomers,

  /**
   * If used with the password flow, grants access to the APIs for creating, modifying and viewing
   * the profile of the customer to whom the access token was issued. If used with the tokens for
   * anonymous sessions, grants access to sign up and sign in.
   */
  manageMyProfile,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to model in a
   * merchant.
   */
  manageTypes,

  /**
   * Grants access to the APIs for viewing anything related to model in a merchant.
   */
  viewTypes,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to payment in a
   * merchant.
   */
  managePayments,

  /**
   * Grants access to the APIs for viewing anything related to payment in a merchant.
   */
  viewPayments,

  /**
   * Grants access to the access tokens for Anonymous Sessions.
   */
  createAnonymousToken,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to subscriptions
   * in a merchant.
   */
  manageSubscriptions;
}
