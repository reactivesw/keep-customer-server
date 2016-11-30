package io.reactivesw.orders.carts.domains.entities.values;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.entities.MoneyEntity;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "orders_carts_shipping_rate_value")
public class ShippingRateValue extends BaseIdEntity{

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
}
