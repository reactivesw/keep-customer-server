package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetDescriptionMapper implements ZoneUpdateMapper {

  /**
   * set description.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(ZoneEntity entity, UpdateAction action) {
    entity.setDescription(((SetDescription) action).getDescription());
  }
}
