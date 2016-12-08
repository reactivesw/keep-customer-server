package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.action.AddShippingRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;

import java.util.HashSet;
import java.util.Objects;

/**
 * Created by umasuo on 16/12/8.
 */
public class RemoveShippingRateMapper implements ShippingMethodUpdateMapper {

  @Override
  public void setAction(ShippingMethodEntity entity, UpdateAction action) {
    AddShippingRate shippingRate = (AddShippingRate) action;

    ShippingRateValue value = ShippingRateMapper.convertModelToEntity(shippingRate
        .getShippingRate());

    entity.getZoneRates().parallelStream().peek(zoneRateValue -> {
      if (Objects.equals(zoneRateValue.getZone(), shippingRate.getZone())) {
        zoneRateValue.getShippingRates().remove(value);
      }
    });
  }

}
