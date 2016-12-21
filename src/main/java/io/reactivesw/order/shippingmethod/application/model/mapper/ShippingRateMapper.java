package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;

/**
 * Created by umasuo on 16/12/8.
 */
public class ShippingRateMapper {

  public static ShippingRateValue modelToEntity(ShippingRate shippingRate) {
    ShippingRateValue value = null;

    if (shippingRate != null) {
      value = new ShippingRateValue();
      value.setFreeAbove(MoneyMapper.modelToEntity(shippingRate.getFreeAbove()));
      value.setPrice(MoneyMapper.modelToEntity(shippingRate.getPrice()));
    }

    return value;
  }

  public static ShippingRate entityToModel(ShippingRateValue entity) {
    ShippingRate model = null;

    if (entity != null) {
      model = new ShippingRate();

      model.setFreeAbove(MoneyMapper.entityToModel(entity.getFreeAbove()));
      model.setPrice(MoneyMapper.entityToModel(entity.getPrice()));
    }

    return model;
  }
}
