package io.reactivesw.customer.server.cart.enums.orders;

/**
 * Values of the ShipmentState enumeration.
 * Created by Davis on 16/11/17.
 */
public enum ShipmentState {

  /**
   * Shipped shipment state.
   */
  Shipped,
  /**
   * Ready shipment state.
   */
  Ready,
  /**
   * Pending shipment state.
   */
  Pending,
  /**
   * Delayed shipment state.
   */
  Delayed,
  /**
   * Partial shipment state.
   */
  Partial,
  /**
   * Backorder shipment state.
   */
  Backorder;

}
