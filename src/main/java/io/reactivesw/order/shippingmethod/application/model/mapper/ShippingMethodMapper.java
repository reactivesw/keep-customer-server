package io.reactivesw.order.shippingmethod.application.model.mapper;

import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethodDraft;
import io.reactivesw.order.shippingmethod.application.model.ZoneRate;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue;

import java.util.Collection;
import java.util.HashSet;
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


  public static List<ShippingMethod> listEntityToListModel(Collection<ShippingMethodEntity>
                                                               entities) {
    return entities.parallelStream().map(
        shippingMethodEntity -> ShippingMethodMapper.entityToModel(shippingMethodEntity)
    ).collect(Collectors.toList());
  }

  public static ShippingMethodEntity modelToEntity(ShippingMethodDraft model) {
    ShippingMethodEntity entity = null;
    if (model != null) {
      entity = new ShippingMethodEntity();
      entity.setAsDefault(entity.getAsDefault());
      entity.setName(model.getName());
      entity.setDescription(model.getDescription());

      String tax = model.getTaxCategory() == null ? null : model.getTaxCategory().getId();
      entity.setTaxCategory(tax);

      Set<ZoneRateValue> zoneRateValues = null;
      List<ZoneRate> zones = model.getZoneRates();
      if (zones != null) {
        zoneRateValues = zones.parallelStream().map(
            zoneRate -> ZoneRateMapper.modelToEntity(zoneRate)
        ).collect(Collectors.toSet());
      }
      entity.setZoneRates(zoneRateValues);

    }
    return entity;
  }

}
