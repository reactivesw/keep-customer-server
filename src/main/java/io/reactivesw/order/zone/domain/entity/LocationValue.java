package io.reactivesw.order.zone.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/8.
 */
@Entity
@Table(name = "order_zone_location")
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

  /**
   * Gets country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets country.
   *
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * equals.
   *
   * @param obj Objec
   * @return Boolean
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (this == obj) {
      result = true;
    }
    if (this != obj && obj instanceof LocationValue) {
      LocationValue that = (LocationValue) obj;
      result = Objects.equals(this.getCountry(), that.getCountry())
          && Objects.equals(this.getState(), that.getState());
    }


    return result;

  }

  /**
   * hash code.
   *
   * @return
   */
  @Override
  public int hashCode() {
    int result = getCountry() == null ? 0 : getCountry().hashCode();
    result = 31 * result + (getState() == null ? 0 : getState().hashCode());
    return result;
  }
}
