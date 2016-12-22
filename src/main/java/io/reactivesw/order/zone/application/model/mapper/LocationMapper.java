package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.order.zone.application.model.Location;
import io.reactivesw.order.zone.domain.entity.LocationValue;

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
  public static LocationValue modelToEntity(Location model) {
    LocationValue entity = new LocationValue();
    entity.setCountry(model.getCountry());
    entity.setState(model.getState());
    return entity;
  }

  /**
   * convert Location to  LocationValue
   *
   * @param entity
   * @return
   */
  public static Location entityToModel(LocationValue entity) {
    Location model = new Location();
    model.setCountry(entity.getCountry());
    model.setState(entity.getState());
    return model;
  }
}
