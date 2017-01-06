package io.reactivesw.order.shippingmethod.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_shipping_method_shipping_rate")
public class ShippingRateValue extends BaseIdEntity {

  /**
   * price.
   */
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private MoneyEntity price;

  /**
   * free above.
   */
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
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
   * equals method.
   * one zone rate does not contain two shipping rates with the same currency.
   *
   * @param obj object
   * @return result
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (this == obj) {
      result = true;
    }
    if (this != obj && obj instanceof ShippingRateValue) {
      ShippingRateValue that = (ShippingRateValue) obj;
      result = Objects.equals(this.getPrice(), that.getPrice())
          && Objects.equals(this.getFreeAbove(), that.getFreeAbove());
    }
    return result;
  }

  /**
   * hash code.
   *
   * @return
   */
  @Override
  public int hashCode() {
    int result = getPrice() == null ? 0 : getPrice().hashCode();
    result = 31 * result + (getFreeAbove() == null ? 0 : getFreeAbove().hashCode());
    return result;
  }
}
