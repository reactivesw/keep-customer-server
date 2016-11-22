package io.reactivesw.orders.carts.enums;

/**
 * Created by umasuo on 16/11/17.
 */
public enum CartState {

  /**
   * The carts can be updated and ordered. It is the default state.
   */
  Active,

  /**
   * Anonymous carts whose content was merged into a customers carts on signin. No further operations
   * on the carts are allowed.
   */
  Merged,

  /**
   * The carts was ordered. No further operations on the carts are allowed.
   */
  Ordered;

}
