package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.Location;
import io.reactivesw.order.zone.application.model.action.AddLocation;
import io.reactivesw.order.zone.domain.entity.LocationValue;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class LocationMapper {

  /**
   * convert Location to  LocationValue
   *
   * @param model
   * @return
   */
  public static LocationValue convertModelToEntity(Location model) {
    LocationValue entity = new LocationValue();
    entity.setCountry(model.getCountry());
    entity.setState(model.getState());
    return entity;
  }
}
