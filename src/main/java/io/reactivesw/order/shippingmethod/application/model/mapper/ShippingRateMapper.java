package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;

/**
 * Created by umasuo on 16/12/8.
 */
public class ShippingRateMapper {

  public static ShippingRateValue convertModelToEntity(ShippingRate shippingRate) {
    ShippingRateValue value = new ShippingRateValue();
    value.setFreeAbove(MoneyMapper.convertModelToEntity(shippingRate.getFreeAbove()));
    value.setPrice(MoneyMapper.convertModelToEntity(shippingRate.getPrice()));
    return value;
  }
}
