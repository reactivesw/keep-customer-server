package io.reactivesw.order.cartdiscount.application.model;

import io.reactivesw.order.cartdiscount.infrastructure.enums.DiscountTargetType;
import lombok.Data;

/**
 * Created by Davis on 16/11/17.
 */
@Data
public class CartDiscountTarget {

  /**
   * Defines what part of the cart will be discounted.
   * Currently discounts can be applied on LineItems, CustomLineItems and ShippingInfo.
   */
  private DiscountTargetType type;

  /**
   * A valid target predicate. The discount will be applied when the predicates matched.
   */
  private String predicate;
}
