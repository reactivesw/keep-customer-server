package io.reactivesw.orders.carts.domains.entities.values;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "orders_carts_sub_rate")
public class SubRateValue extends BaseIdEntity {

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * amount.
   */
  @Column
  private Float amount;

  /**
   * to string method.
   * @return
   */
  @Override
  public String toString() {
    return "SubRateValue{" +
            "name='" + name + '\'' +
            ", amount=" + amount +
            '}';
  }

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
   * Gets amount.
   *
   * @return the amount
   */
  public Float getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(Float amount) {
    this.amount = amount;
  }
}
