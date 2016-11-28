package io.reactivesw.catalog.taxcategories.entities;

import io.reactivesw.common.entities.BaseIdEntity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_tax_rate")
public class TaxRateEntity extends BaseIdEntity {
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
   * The Included in price.
   */
  @Column(name = "included_in_price")
  private Boolean includedInPrice;

  /**
   * The Country.
   */
  @Column(name = "country")
  private String country;

  /**
   * The State.
   */
  @Column(name = "state")
  private String state;

  /**
   * The Sub rates.
   */
  @OneToMany
  private Set<SubRateEntity> subRates;

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
  public Set<SubRateEntity> getSubRates() {
    return subRates;
  }

  /**
   * Sets sub rates.
   *
   * @param subRates the sub rates
   */
  public void setSubRates(Set<SubRateEntity> subRates) {
    this.subRates = subRates;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "TaxRateEntity{"
        + "id=" + id
        + "name='" + name + '\''
        + ", amount=" + amount
        + ", includedInPrice=" + includedInPrice
        + ", country='" + country + '\''
        + ", state='" + state + '\''
        + ", subRates=" + subRates
        + '}';
  }
}
