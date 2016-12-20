package io.reactivesw.order.zone.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import lombok.Data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_zone")
@Data
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
  @OneToMany
  private Set<LocationValue> locations;
}
