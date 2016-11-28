package io.reactivesw.orders.carts.entities.values;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "orders_carts_payment_info")
public class PaymentInfoValue extends BaseIdEntity {

  /**
   * name.
   */
  @Column
  private String name;

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
}
