package io.reactivesw.catalog.taxcategories.entities;

import io.reactivesw.common.entities.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_tax_rate")
public class TaxRate extends BaseIdEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "amount", precision = 8, scale = 7)
  private BigDecimal amount;

  @Column(name = "included_in_price")
  private Boolean includedInPrice;

  @Column(name = "country")
  private String country;

  @Column(name = "state")
  private String state;

  @OneToMany
  private Set<SubRate> subRates;

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
  public Set<SubRate> getSubRates() {
    return subRates;
  }

  /**
   * Sets sub rates.
   *
   * @param subRates the sub rates
   */
  public void setSubRates(Set<SubRate> subRates) {
    this.subRates = subRates;
  }

  @Override
  public String toString() {
    return "TaxRate{" +
        "name='" + name + '\'' +
        ", amount=" + amount +
        ", includedInPrice=" + includedInPrice +
        ", country='" + country + '\'' +
        ", state='" + state + '\'' +
        ", subRates=" + subRates +
        '}';
  }
}
