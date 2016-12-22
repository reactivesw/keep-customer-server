package io.reactivesw.order.shippingmethod.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_shipping_method")
@Data
@EqualsAndHashCode
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

}
