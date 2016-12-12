package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetNameMapper implements ShippingMethodUpdateMapper {

  /**
   * set name.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void setAction(ShippingMethodEntity entity, UpdateAction action) {
    entity.setName(((SetName) action).getName());
  }
}
