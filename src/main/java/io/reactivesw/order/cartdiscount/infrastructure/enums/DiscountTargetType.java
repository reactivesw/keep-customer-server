package io.reactivesw.order.cartdiscount.infrastructure.enums;

/**
 * Created by umasuo on 16/12/9.
 */
public enum DiscountTargetType {

  /**
   * use lien item for discount.
   */
  LINE_ITEM,

  /**
   * use custom line item for discount.
   */
  CUSTOM_LINE_ITEM,

  /**
   * use shipping for discount.
   */
  SHIPPING;

}
