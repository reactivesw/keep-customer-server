package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.Location;
import io.reactivesw.order.zone.application.model.action.AddLocation;
import io.reactivesw.order.zone.domain.entity.LocationValue;
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
  public void setAction(ZoneEntity entity, UpdateAction action) {
    AddLocation location = (AddLocation) action;
    entity.getLocation().add(LocationMapper.convertModelToEntity(location.getLocation()));
  }

}
