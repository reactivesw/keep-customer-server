package io.reactivesw.order.shippingmethod.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_shipping_method")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShippingMethodEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  @Version
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
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<ZoneRateValue> zoneRates;

  /**
   * is default for a project.
   */
  @Column
  private Boolean asDefault;

}
