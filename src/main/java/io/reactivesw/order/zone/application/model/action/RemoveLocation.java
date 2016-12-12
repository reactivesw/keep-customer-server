package io.reactivesw.order.zone.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.Location;

/**
 * Created by umasuo on 16/12/8.
 */
public class RemoveLocation implements UpdateAction {

  /**
   * location.
   */
  private Location location;

  /**
   * Gets location.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Sets location.
   *
   * @param location the location
   */
  public void setLocation(Location location) {
    this.location = location;
  }
}
