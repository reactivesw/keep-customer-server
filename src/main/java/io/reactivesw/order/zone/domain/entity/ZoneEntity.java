package io.reactivesw.order.zone.domain.entity;

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

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_zone")
@Data
@EqualsAndHashCode(callSuper = false)
public class ZoneEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  private Integer version;

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * description.
   */
  @Column
  private String description;

  /**
   * locations.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocationValue> locations;
}
