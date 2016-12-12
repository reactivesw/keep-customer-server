package io.reactivesw.order.shippingmethod.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_shipping_method_shipping_method")
public class ShippingMethodEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  private Integer version;

  /**
   * name of shipping method.
   */
  @Column
  private String name;

  /**
   * description of shipping method.
   */
  @Column
  private String description;

  /**
   * tax category id.
   */
  @Column
  private String taxCategory;

  /**
   * zone rates.
   */
  @OneToMany
  private Set<ZoneRateValue> zoneRates;

  /**
   * is default for a project.
   */
  @Column
  private Boolean asDefault;


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
   * Gets tax category.
   *
   * @return the tax category
   */
  public String getTaxCategory() {
    return taxCategory;
  }

  /**
   * Sets tax category.
   *
   * @param taxCategory the tax category
   */
  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
  }

  /**
   * Gets zone rates.
   *
   * @return the zone rates
   */
  public Set<ZoneRateValue> getZoneRates() {
    return zoneRates;
  }

  /**
   * Sets zone rates.
   *
   * @param zoneRates the zone rates
   */
  public void setZoneRates(Set<ZoneRateValue> zoneRates) {
    this.zoneRates = zoneRates;
  }

  /**
   * Gets as default.
   *
   * @return the as default
   */
  public Boolean getAsDefault() {
    return asDefault;
  }

  /**
   * Sets as default.
   *
   * @param asDefault the as default
   */
  public void setAsDefault(Boolean asDefault) {
    this.asDefault = asDefault;
  }
}
