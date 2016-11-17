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
}
