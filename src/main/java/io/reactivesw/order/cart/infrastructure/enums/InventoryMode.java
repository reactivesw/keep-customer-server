package io.reactivesw.order.cart.infrastructure.enums;

/**
 * Values of the InventoryMode enumeration:
 * Created by umasuo on 16/11/17.
 */
public enum InventoryMode {

  /**
   * Orders are tracked on inventory. That means, ordering a LineItem will decrement the available
   * quantity on the respective InventoryEntry. Creating an order will succeed even if the line
   * item’s available quantity is zero or negative. But creating an order will fail with an
   * OutOfStock error if no matching inventory entry exists for a line item.
   */
  TrackOnly,

  /**
   * Creating an order will fail with an OutOfStock error if an unavailable line item exists. Line
   * items in the cart are only reserved for the duration of the ordering transaction.
   */
  ReserveOnOrder,

  /**
   * Adding items to cart and ordering is independent of inventory. No inventory checks or
   * modifications.
   */
  None;

}
