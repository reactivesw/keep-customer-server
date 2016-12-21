package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import io.reactivesw.order.shippingmethod.application.model.ZoneRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingRateValue;
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/8.
 */
public final class ZoneRateMapper {

  public static ZoneRateValue modelToEntity(ZoneRate model) {
    ZoneRateValue entity = null;
    if (model != null) {
      entity = new ZoneRateValue();
      entity.setZone(model.getZone().getId());

      if (model.getShippingRates() != null) {
        Set<ShippingRateValue> shippingRates = model.getShippingRates().parallelStream().map(
            shippingRate -> ShippingRateMapper.modelToEntity(shippingRate)
        ).collect(Collectors.toSet());
        entity.setShippingRates(shippingRates);
      }

    }
    return entity;
  }

  public static ZoneRate entityToModel(ZoneRateValue entity) {
    ZoneRate model = null;
    if (entity != null) {
      model = new ZoneRate();

      Reference zoneRef = new Reference();
      zoneRef.setId(entity.getZone());
      zoneRef.setTypeId(ReferenceTypes.ZONE.getType());
      model.setZone(zoneRef);

      Set<ShippingRateValue> rates = entity.getShippingRates();
      if (rates != null) {
        List<ShippingRate> shippingRates = rates.parallelStream().map(
            shippingRateValue -> ShippingRateMapper.entityToModel(shippingRateValue)
        ).collect(Collectors.toList());
        model.setShippingRates(shippingRates);
      }

    }

    return model;
  }

}
