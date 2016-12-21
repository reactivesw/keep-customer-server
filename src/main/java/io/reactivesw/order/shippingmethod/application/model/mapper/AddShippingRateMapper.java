package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.action.AddShippingRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;

import java.util.Objects;

/**
 * Created by umasuo on 16/12/8.
 */
public class AddShippingRateMapper implements ShippingMethodUpdateMapper {

  /**
   * add shipping method.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(ShippingMethodEntity entity, UpdateAction action) {
    AddShippingRate shippingRate = (AddShippingRate) action;

    ShippingRateValue value = ShippingRateMapper.modelToEntity(shippingRate
        .getShippingRate());

    entity.getZoneRates().parallelStream().peek(zoneRateValue -> {
      if (Objects.equals(zoneRateValue.getZone(), shippingRate.getZone())) {
        zoneRateValue.getShippingRates().add(value);
      }
    });

  }
}
