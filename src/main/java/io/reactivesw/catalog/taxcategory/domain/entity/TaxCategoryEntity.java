package io.reactivesw.catalog.taxcategory.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/23.
 */
@Table(name = "catalog_tax_category_tax_category_entity")
@Entity
public class TaxCategoryEntity extends BaseAllEntity {

  /**
   * The Version.
   */
  @Column
  private Integer version;

  /**
   * The Name.
   */
  @Column
  private String name;

  /**
   * The Description.
   */
  @Column
  private String description;

  /**
   * The Rates.
   */
  @OneToMany
  private Set<TaxRateEntity> rates;

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
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
  public Set<TaxRateEntity> getRates() {
    return rates;
  }

  /**
   * Sets rates.
   *
   * @param rates the rates
   */
  public void setRates(Set<TaxRateEntity> rates) {
    this.rates = rates;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "TaxCategoryEntity{"
        + "id=" + id
        + "version=" + version
        + ", name='" + name + '\''
        + ", description='" + description + '\''
        + ", rates=" + rates
        + '}';
  }
}
