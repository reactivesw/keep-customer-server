package io.reactivesw.catalog.taxcategory.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "catalog_tax_category_sub_rate")
public class SubRateEntity extends BaseIdEntity {
  /**
   * The Name.
   */
  @Column(name = "name")
  private String name;

  /**
   * The Amount.
   */
  @Column(name = "amount", precision = 8, scale = 7)
  private BigDecimal amount;

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
  public BigDecimal getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "SubRateEntity{"
        + "name='" + name + '\''
        + ", amount=" + amount
        + '}';
  }
}
