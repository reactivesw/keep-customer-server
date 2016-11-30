package io.reactivesw.common.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/30.
 */
@Entity
@Table(name = "common_money")
public class MoneyEntity extends BaseIdEntity {
  /**
   * The Currency code.
   */
  private String currencyCode;

  /**
   * The Cent amount.
   */
  private Integer centAmount;

  /**
   * default constructor.
   */
  public MoneyEntity() {

  }

  /**
   * constructor.
   *
   * @param currencyCode String
   * @param centAmount   Integer
   */
  public MoneyEntity(String currencyCode, Integer centAmount) {
    this.currencyCode = currencyCode;
    this.centAmount = centAmount;
  }

  /**
   * Gets currency code.
   *
   * @return the currency code
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * Sets currency code.
   *
   * @param currencyCode the currency code
   */
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  /**
   * Gets cent amount.
   *
   * @return the cent amount
   */
  public Integer getCentAmount() {
    return centAmount;
  }

  /**
   * Sets cent amount.
   *
   * @param centAmount the cent amount
   */
  public void setCentAmount(Integer centAmount) {
    this.centAmount = centAmount;
  }
}
