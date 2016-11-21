package io.reactivesw.customer.server.common.models;

import java.util.Objects;

/**
 * Created by Davis on 16/11/16.
 */
public class Money {
  /**
   * The Currency code.
   */
  private String currencyCode;
  /**
   * The Cent amount.
   */
  private Integer centAmount;

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

  @Override
  public boolean equals(Object obj) {
    boolean equalsResult = false;
    if (this == obj) {
      equalsResult = true;
    } else if (obj instanceof Money) {
      final Money other = (Money) obj;
      equalsResult = Objects.equals(currencyCode, other.currencyCode)
          && Objects.equals(centAmount, other.centAmount);
    }
    return equalsResult;

  }

  @Override
  public int hashCode() {
    return Objects.hash(currencyCode, centAmount);
  }

  @Override
  public String toString() {
    return "Money{" +
        "currencyCode='" + currencyCode + '\'' +
        ", centAmount=" + centAmount +
        '}';
  }
}
