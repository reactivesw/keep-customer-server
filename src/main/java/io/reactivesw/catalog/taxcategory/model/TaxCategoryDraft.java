package io.reactivesw.catalog.taxcategory.model;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class TaxCategoryDraft {

  /**
   * The Name.
   */
  private String name;

  /**
   * The Description.
   */
  private String description;

  /**
   * The Rates.
   */
  private List<TaxRateDraft> rates;

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
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets rates.
   *
   * @return the rates
   */
  public List<TaxRateDraft> getRates() {
    return rates;
  }

  /**
   * Sets rates.
   *
   * @param rates the rates
   */
  public void setRates(List<TaxRateDraft> rates) {
    this.rates = rates;
  }

  /**
   * toString method.
   *
   * @return String.
   */
  @Override
  public String toString() {
    return "TaxCategoryDraft{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", rates=" + rates +
        '}';
  }
}
