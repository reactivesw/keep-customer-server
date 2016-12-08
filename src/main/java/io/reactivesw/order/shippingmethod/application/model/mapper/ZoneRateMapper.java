package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.order.shippingmethod.application.model.ZoneRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by umasuo on 16/12/8.
 */
public final class ZoneRateMapper {

  public static ZoneRateValue convertModelToEntity(ZoneRate rate) {
    ZoneRateValue entity = new ZoneRateValue();
    entity.setZone(rate.getZone().getId());
    Set<ShippingRateValue> shippingRates = new HashSet<>();

    if (!Objects.isNull(rate.getShippingRates())) {
      rate.getShippingRates().parallelStream().peek(shippingRate -> {
        shippingRates.add(ShippingRateMapper.convertModelToEntity(shippingRate));
      });
    }
    entity.setShippingRates(shippingRates);
    return entity;
  }
}
