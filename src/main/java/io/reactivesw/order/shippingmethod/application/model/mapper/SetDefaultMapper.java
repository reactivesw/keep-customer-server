package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.action.SetDefault;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetDefaultMapper implements ShippingMethodUpdateMapper {

  @Override
  public void handle(ShippingMethodEntity entity, UpdateAction action) {
    entity.setAsDefault(((SetDefault)action).getDefault());
  }
}
