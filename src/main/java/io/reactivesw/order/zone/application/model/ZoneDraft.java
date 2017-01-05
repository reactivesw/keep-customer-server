package io.reactivesw.order.zone.application.model;

import lombok.Data;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/11/17.
 */
@Data
public class ZoneDraft {
  /**
   * The Name.
   */
  @NotNull
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
