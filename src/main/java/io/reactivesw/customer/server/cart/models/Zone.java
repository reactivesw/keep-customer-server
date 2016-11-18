package io.reactivesw.customer.server.cart.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class Zone {

  /**
   * The unique ID of the zone.
   */
  private String id;

  /**
   * The current version of the zone.
   */
  private Integer version;

  /**
   * The Created at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * The Name.
   */
  private String name;

  /**
   * The Description.
   */
  private String description;

  /**
   * The Locations.
   */
  private List<Location> locations;
}
