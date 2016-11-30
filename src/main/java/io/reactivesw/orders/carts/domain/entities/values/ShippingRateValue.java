package io.reactivesw.orders.carts.domain.entities.values;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.reactivesw.common.models.Statics;
import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.utils.MoneyJsonConverter;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "orders_carts_shipping_rate_value")
public class ShippingRateValue extends BaseIdEntity{

  /**
   * price in money.
   */
  @Column(name = "price", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = MoneyJsonConverter.class)
  private Money price;

  /**
   * free above in money.
   */
  @Column(name = "free_above", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = MoneyJsonConverter.class)
  private Money freeAbove;

  /**
   * Gets price.
   *
   * @return the price
   */
  public Money getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(Money price) {
    this.price = price;
  }

  /**
   * Gets free above.
   *
   * @return the free above
   */
  public Money getFreeAbove() {
    return freeAbove;
  }

  /**
   * Sets free above.
   *
   * @param freeAbove the free above
   */
  public void setFreeAbove(Money freeAbove) {
    this.freeAbove = freeAbove;
  }
}
