package io.reactivesw.order.cartdiscount.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.order.cartdiscount.infrastructure.enums.DiscountTargetType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/9.
 */
@Entity
@Table(name = "order_cart_discount_target")
public class CartDiscountTargetValue extends BaseIdEntity {

  /**
   * The Type.
   */
  private DiscountTargetType type;

  /**
   * The Predicate.
   * The discount will be applied to line items that are matched by the predicate.
   * if the predicate is null, then all of items are matched.
   * * For now, we only support all.
   */
  private String predicate;

  /**
   * Gets type.
   *
   * @return the type
   */
  public DiscountTargetType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(DiscountTargetType type) {
    this.type = type;
  }

  /**
   * Gets predicate.
   *
   * @return the predicate
   */
  public String getPredicate() {
    return predicate;
  }

  /**
   * Sets predicate.
   *
   * @param predicate the predicate
   */
  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }
}
