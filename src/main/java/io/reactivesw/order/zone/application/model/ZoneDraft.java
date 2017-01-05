package io.reactivesw.order.zone.application.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
@Data
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
