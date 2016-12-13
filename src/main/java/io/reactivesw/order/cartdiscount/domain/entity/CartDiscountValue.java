package io.reactivesw.order.cartdiscount.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.cartdiscount.infrastructure.enums.CartDiscountType;

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
public class CartDiscountValue extends BaseIdEntity {

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

  /**
   * Gets type.
   *
   * @return the type
   */
  public CartDiscountType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(CartDiscountType type) {
    this.type = type;
  }

  /**
   * Gets permyriad.
   *
   * @return the permyriad
   */
  public Integer getPermyriad() {
    return permyriad;
  }

  /**
   * Sets permyriad.
   *
   * @param permyriad the permyriad
   */
  public void setPermyriad(Integer permyriad) {
    this.permyriad = permyriad;
  }

  /**
   * Gets money.
   *
   * @return the money
   */
  public Set<MoneyEntity> getMoney() {
    return money;
  }

  /**
   * Sets money.
   *
   * @param money the money
   */
  public void setMoney(Set<MoneyEntity> money) {
    this.money = money;
  }
}
