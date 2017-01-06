package io.reactivesw.order.shippingmethod.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_shipping_method_zone_rate")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZoneRateValue extends BaseIdEntity {

  /**
   * zone id.
   */
  @Column
  private String zone;

  /**
   * shipping rates.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<ShippingRateValue> shippingRates;
}
