package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.action.AddZone;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue;

import java.util.Objects;

/**
 * Created by umasuo on 16/12/8.
 */
public class RemoveZoneMapper implements ShippingMethodUpdateMapper {

  @Override
  public void handle(ShippingMethodEntity entity, UpdateAction action) {
    AddZone zone = (AddZone) action;
    ZoneRateValue value = new ZoneRateValue();
    value.setZone(zone.getZone().getId());
    entity.getZoneRates().remove(value);
  }
}
