package io.reactivesw.order.zone.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.Location;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by umasuo on 16/12/8.
 */
@Getter
@Setter
public class AddLocation implements UpdateAction {

  /**
   * location.
   */
  private Location location;

  @Override
  public String getActionName() {
    return null;
  }
}
