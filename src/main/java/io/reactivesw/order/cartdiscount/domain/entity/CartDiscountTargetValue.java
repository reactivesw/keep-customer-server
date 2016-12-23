package io.reactivesw.order.cartdiscount.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.order.cartdiscount.infrastructure.enums.DiscountTargetType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/9.
 */
@Entity
@Table(name = "order_cart_discount_target")
@Data
@EqualsAndHashCode(callSuper = false)
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
}
