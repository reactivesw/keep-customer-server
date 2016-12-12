package io.reactivesw.order.zone.domain.entity;

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
@Table(name = "order_zone_zone")
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
  private Set<LocationValue> location;

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
   * Gets location.
   *
   * @return the location
   */
  public Set<LocationValue> getLocation() {
    return location;
  }

  /**
   * Sets location.
   *
   * @param location the location
   */
  public void setLocation(Set<LocationValue> location) {
    this.location = location;
  }
}
