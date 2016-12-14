package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;

/**
 * Created by umasuo on 16/12/8.
 */
public class ShippingRateMapper {

  public static ShippingRateValue convertModelToEntity(ShippingRate shippingRate) {
    ShippingRateValue value = new ShippingRateValue();
    value.setFreeAbove(MoneyMapper.modelToEntity(shippingRate.getFreeAbove()));
    value.setPrice(MoneyMapper.modelToEntity(shippingRate.getPrice()));
    return value;
  }
}
