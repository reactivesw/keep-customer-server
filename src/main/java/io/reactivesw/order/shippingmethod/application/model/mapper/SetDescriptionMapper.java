package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetDescriptionMapper implements ShippingMethodUpdateMapper {

  /**
   * set description.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(ShippingMethodEntity entity, UpdateAction action) {
    entity.setDescription(((SetDescription) action).getDescription());
  }
}
