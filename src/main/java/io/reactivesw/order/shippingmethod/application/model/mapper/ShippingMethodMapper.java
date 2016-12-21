package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.shippingmethod.application.model.ZoneRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/21.
 */
public class ShippingMethodMapper {

  public static ShippingMethod entityToModel(ShippingMethodEntity entity) {
    ShippingMethod model = null;
    if (entity != null) {
      model = new ShippingMethod();
      model.setId(entity.getId());
      model.setLastModifiedAt(entity.getLastModifiedAt());
      model.setName(entity.getName());
      model.setDescription(entity.getDescription());
      model.setCreatedAt(entity.getCreatedAt());
      model.setIsDefault(entity.getAsDefault());

      Reference taxRef = new Reference();
      taxRef.setId(entity.getTaxCategory());
      taxRef.setTypeId(ReferenceTypes.TAXCATEGORY.getType());
      model.setTaxCategory(taxRef);

      model.setVersion(entity.getVersion());

      Set<ZoneRateValue> zoneRates = entity.getZoneRates();
      List<ZoneRate> rates = zoneRates.parallelStream().map(
          zoneRateValue -> ZoneRateMapper.entityToModel(zoneRateValue)
      ).collect(Collectors.toList());
      model.setZoneRates(rates);
    }
    return model;
  }

}
