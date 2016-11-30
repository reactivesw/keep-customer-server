package io.reactivesw.orders.carts.domains.entities.values;

import io.reactivesw.common.entities.BaseIdEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 * //TODO should we keep this in snapshot?
 */
@Entity
@Table(name = "orders_carts_tax_rate")
public class TaxRateValue extends BaseIdEntity {

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
   * if inclued in price.
   */
  @Column
  private Boolean includedInPrice;

  /**
   * country.
   */
  @Column
  private String country;

  /**
   * state.
   */
  @Column
  private String state;

  /**
   * list of sub rate.
   */
  @OneToMany
  private Set<SubRateValue> subRates;

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
  public Set<SubRateValue> getSubRates() {
    return subRates;
  }

  /**
   * Sets sub rates.
   *
   * @param subRates the sub rates
   */
  public void setSubRates(Set<SubRateValue> subRates) {
    this.subRates = subRates;
  }

  /**
   * to string method.
   * @return String
   */
  @Override
  public String toString() {
    return "TaxRateValue{"
        + "name='" + name + '\''
        + ", amount=" + amount
        + ", includedInPrice=" + includedInPrice
        + ", country='" + country + '\''
        + ", state='" + state + '\''
        + ", subRates=" + subRates
        + '}';
  }
}
