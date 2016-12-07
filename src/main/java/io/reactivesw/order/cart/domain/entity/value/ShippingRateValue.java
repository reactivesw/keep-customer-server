package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_cart_shipping_rate")
public class ShippingRateValue extends BaseIdEntity {

  /**
   * price in money.
   */
  @OneToOne
  private MoneyEntity price;

  /**
   * free above in money.
   */
  @OneToOne
  private MoneyEntity freeAbove;

  /**
   * Gets price.
   *
   * @return the price
   */
  public MoneyEntity getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(MoneyEntity price) {
    this.price = price;
  }

  /**
   * Gets free above.
   *
   * @return the free above
   */
  public MoneyEntity getFreeAbove() {
    return freeAbove;
  }

  /**
   * Sets free above.
   *
   * @param freeAbove the free above
   */
  public void setFreeAbove(MoneyEntity freeAbove) {
    this.freeAbove = freeAbove;
  }

  /**
   * to string method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ShippingRateValue{"
        + "price=" + price
        + ", freeAbove=" + freeAbove
        + '}';
  }
}
