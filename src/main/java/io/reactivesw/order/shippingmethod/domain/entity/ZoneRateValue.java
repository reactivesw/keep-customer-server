package io.reactivesw.order.shippingmethod.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_shipping_method_zone_rate")
public class ZoneRateValue extends BaseIdEntity {

  /**
   * zone id.
   */
  @Column
  private String zone;

  /**
   * shipping rates.
   */
  @OneToMany
  private Set<ShippingRateValue> shippingRates;

  /**
   * Gets zone.
   *
   * @return the zone
   */
  public String getZone() {
    return zone;
  }

  /**
   * Sets zone.
   *
   * @param zone the zone
   */
  public void setZone(String zone) {
    this.zone = zone;
  }

  /**
   * Gets shipping rates.
   *
   * @return the shipping rates
   */
  public Set<ShippingRateValue> getShippingRates() {
    return shippingRates;
  }

  /**
   * Sets shipping rates.
   *
   * @param shippingRates the shipping rates
   */
  public void setShippingRates(Set<ShippingRateValue> shippingRates) {
    this.shippingRates = shippingRates;
  }

  /**
   * equals.
   *
   * @param obj object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (this == obj) {
      result = true;
    }
    if (this != obj && obj instanceof ZoneRateValue) {
      ZoneRateValue that = (ZoneRateValue) obj;
      result = Objects.equals(this.getZone(), that.getZone());
    }
    return result;
  }

  /**
   * hashcode method.
   *
   * @return int
   */
  @Override
  public int hashCode() {
    int result = getZone() == null ? 0 : getZone().hashCode();
    result = 31 * result + (getShippingRates() == null ? 0 : getShippingRates().hashCode());
    return result;
  }
}
