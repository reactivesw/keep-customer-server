package io.reactivesw.order.cartdiscount.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.cartdiscount.infrastructure.enums.CartDiscountType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/9.
 */
@Entity
@Table(name = "order_cart_discount_value")
@Data
@EqualsAndHashCode(callSuper = false)
public class CartDiscountValueValue extends BaseIdEntity {

  /**
   * The Type.reactive or absolute.
   */
  @Column
  private CartDiscountType type;

  /**
   * The Permyriad.
   * Per ten thousand. The fraction the price is reduced. 1000 will result in a 10% price reduction.
   */
  @Column
  private Integer permyriad;

  /**
   * The Money.
   */
  @OneToMany
  private Set<MoneyEntity> money;

}
