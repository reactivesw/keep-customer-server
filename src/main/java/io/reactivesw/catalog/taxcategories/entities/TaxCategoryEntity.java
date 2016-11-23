package io.reactivesw.catalog.taxcategories.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseAllEntity;

/**
 * Created by umasuo on 16/11/23.
 */
@Table(name = "sw_tax_category_entity")
@Entity
public class TaxCategoryEntity extends BaseAllEntity {

  @Column
  private Integer version;

  @Column
  private String name;

  @Column
  private String description;

  @OneToMany
  private Set<TaxRate> rates;

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<TaxRate> getRates() {
    return rates;
  }

  public void setRates(Set<TaxRate> rates) {
    this.rates = rates;
  }
}
