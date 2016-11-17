package io.reactivesw.customer.server.cart.models;

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
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
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
