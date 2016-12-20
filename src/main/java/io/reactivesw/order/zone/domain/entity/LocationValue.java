package io.reactivesw.order.zone.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_zone_location")
@Data
public class LocationValue extends BaseIdEntity {

  /**
   * country.
   */
  @Column
  private String country;

  /**
   * state, province.
   */
  @Column
  private String state;

}
