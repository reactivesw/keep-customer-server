package io.reactivesw.customer.server.catalog.models.draft;

import io.reactivesw.customer.server.common.models.SubRate;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class TaxRateDraft {

  /**
   * The Name.
   */
  private String name;
  /**
   * Percentage in the range of [0..1]. Must be supplied if no subRates are specified.
   * If subRates are specified then the amount can be omitted or
   * it must be the sum of the amounts of all subRates.
   */
  private Float amount;

  /**
   * The Included in price.
   */
  private Boolean includedInPrice;

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 .
   */
  private String country;

  /**
   * The state in the country
   */
  private String state;

  /**
   * Array of SubRate - Optional beta.
   * For countries (e.g. the US) where the total tax is a combination of multiple taxes
   * (e.g. state and local taxes).
   */
  private List<SubRate> subRates;

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

  /**
   * Gets included in price.
   *
   * @return the included in price
   */
  public Boolean getIncludedInPrice() {
    return includedInPrice;
  }

  /**
   * Sets included in price.
   *
   * @param includedInPrice the included in price
   */
  public void setIncludedInPrice(Boolean includedInPrice) {
    this.includedInPrice = includedInPrice;
  }

  /**
   * Gets country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets country.
   *
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Gets sub rates.
   *
   * @return the sub rates
   */
  public List<SubRate> getSubRates() {
    return subRates;
  }

  /**
   * Sets sub rates.
   *
   * @param subRates the sub rates
   */
  public void setSubRates(List<SubRate> subRates) {
    this.subRates = subRates;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "TaxRateDraft{" +
        "name='" + name + '\'' +
        ", amount=" + amount +
        ", includedInPrice=" + includedInPrice +
        ", country='" + country + '\'' +
        ", state='" + state + '\'' +
        ", subRates=" + subRates +
        '}';
  }
}
