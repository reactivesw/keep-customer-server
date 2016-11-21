package io.reactivesw.customer.server.cart.enums.orders;

/**
 * Created by Davis on 16/11/17.
 */
public enum OrderState {

  /**
   * Open order state.
   */
  Open,
  /**
   * Confirmed order state.
   */
  Confirmed,
  /**
   * Complete order state.
   */
  Complete,
  /**
   * Cancelled order state.
   */
  Cancelled;
}