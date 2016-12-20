package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.action.AddLocation;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class RemoveLocationMapper implements ZoneUpdateMapper {

  /**
   * remove Location.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(ZoneEntity entity, UpdateAction action) {
    AddLocation location = (AddLocation) action;
    boolean result = entity.getLocations().remove(LocationMapper.modelToEntity(location
        .getLocation()));

    if (!result) {
      throw new NotExistException("Zone not exist.");
    }
  }
}
