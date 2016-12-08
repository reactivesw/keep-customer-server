package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.order.zone.application.model.mapper.ZoneUpdateMapper;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetNameMapper implements ZoneUpdateMapper {

  /**
   * set name.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void setAction(ZoneEntity entity, UpdateAction action) {
    entity.setName(((SetName) action).getName());
  }
}
