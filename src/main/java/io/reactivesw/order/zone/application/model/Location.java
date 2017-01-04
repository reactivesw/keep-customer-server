package io.reactivesw.order.zone.application.model;

import lombok.Data;

/**
 * Created by Davis on 16/11/17.
 */
@Data
public class Location {

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 .
   */
  private String country;

  /**
   * the state, province.
   */
  private String state;

}
