package io.reactivesw.order.zone.model;

/**
 * Created by Davis on 16/11/17.
 */
public class Location {

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 .
   */
  private String country;

  /**
   * the state, province.
   */
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
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "Location{" +
        "country='" + country + '\'' +
        ", state='" + state + '\'' +
        '}';
  }
}
