package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.action.AddLocation;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class AddLocationMapper implements ZoneUpdateMapper {

  /**
   * set location.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(ZoneEntity entity, UpdateAction action) {
    AddLocation location = (AddLocation) action;
    entity.getLocations().add(LocationMapper.modelToEntity(location.getLocation()));
  }

}
