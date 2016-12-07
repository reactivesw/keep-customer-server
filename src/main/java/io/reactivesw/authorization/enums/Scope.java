package io.reactivesw.authorization.enums;

/**
 * Created by umasuo on 16/11/21.
 */
public enum Scope {
  /**
   * Grants full access to the APIs for the specified project.
   */
  manageProject,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to product in a
   * project. Implies view_products for the same project.
   */
  manageProducts,

  /**
   * Grants access to the APIs for viewing anything related to product in a project.
   */
  viewProducts,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to order in a
   * project. Implies view_orders for the same project.
   */
  manageOrders,

  /**
   * Grants access to the APIs for viewing anything related to order in a project.
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
   * a project. Implies view_customers for the same project.
   */
  manageCustomers,

  /**
   * Grants access to the APIs for viewing anything related to customer in a project.
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
   * project.
   */
  manageTypes,

  /**
   * Grants access to the APIs for viewing anything related to model in a project.
   */
  viewTypes,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to payment in a
   * project.
   */
  managePayments,

  /**
   * Grants access to the APIs for viewing anything related to payment in a project.
   */
  viewPayments,

  /**
   * Grants access to the access tokens for Anonymous Sessions.
   */
  createAnonymousToken,

  /**
   * Grants access to the APIs for creating, modifying and viewing anything related to subscriptions
   * in a project.
   */
  manageSubscriptions;
}
