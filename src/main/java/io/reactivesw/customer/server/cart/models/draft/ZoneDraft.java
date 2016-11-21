package io.reactivesw.customer.server.cart.models.draft;

import io.reactivesw.customer.server.cart.models.Location;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ZoneDraft {
  /**
   * The Name.
   */
  String name;
  /**
   * The Description.
   */
  String description;
  /**
   * The Locations.
   */
  List<Location> locations;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }
}
