package io.reactivesw.catalog.taxcategories.models;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class TaxRate {

  @ApiModelProperty(value = "The id is always set if the tax rate is part of a TaxCategory. The external tax rates in a Cart do not contain an id.",
          required = false)
  private String id;

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(value = "Number Percentage in the range of [0..1]. The sum of the amounts of all subRates, if there are any.",
          required = true)
  private Float amount;

  @ApiModelProperty(required = true)
  private Boolean includedInPrice;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 .",
          required = true)
  private String country;

  @ApiModelProperty(value = "The state in the country",
          required = false)
  private String state;

  @ApiModelProperty(value = "For countries (e.g. the US) where the total tax is a combination of multiple taxes (e.g. state and local taxes).",
          required = true)
  private List<SubRate> subRates;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
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
  public float getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(float amount) {
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
   * @return String
   */
  @Override
  public String toString() {
    return "TaxRate{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", amount=" + amount +
        ", includedInPrice=" + includedInPrice +
        ", country='" + country + '\'' +
        ", state='" + state + '\'' +
        ", subRates=" + subRates +
        '}';
  }
}
