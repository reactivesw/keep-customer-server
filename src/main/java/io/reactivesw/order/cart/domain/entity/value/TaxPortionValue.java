package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_cart_tax_portion")
public class TaxPortionValue extends BaseIdEntity {

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * rate.
   */
  @Column
  private Float rate;

  /**
   * amount of money.
   */
  @OneToOne
  private MoneyEntity amount;

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets rate.
   *
   * @return the rate
   */
  public Float getRate() {
    return rate;
  }

  /**
   * Sets rate.
   *
   * @param rate the rate
   */
  public void setRate(Float rate) {
    this.rate = rate;
  }

  /**
   * Gets amount.
   *
   * @return the amount
   */
  public MoneyEntity getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(MoneyEntity amount) {
    this.amount = amount;
  }

  /**
   * to string method.
   * @return String
   */
  @Override
  public String toString() {
    return "TaxPortionValue{"
        + "name='" + name + '\''
        + ", rate=" + rate
        + ", amount=" + amount
        + '}';
  }
}
