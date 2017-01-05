package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.order.zone.application.model.Location;
import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.order.zone.application.model.ZoneDraft;
import io.reactivesw.order.zone.domain.entity.LocationValue;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/20.
 */
public class ZoneMapper {

  /**
   * convert entity to model;
   *
   * @param entity
   * @return
   */
  public static Zone entityToModel(ZoneEntity entity) {
    Zone model = new Zone();
    model.setVersion(entity.getVersion());
    model.setName(entity.getName());
    model.setCreatedAt(entity.getCreatedAt());
    model.setDescription(entity.getDescription());
    model.setId(entity.getId());
    model.setLastModifiedAt(entity.getLastModifiedAt());

    List<Location> locations = entity.getLocations().parallelStream().map(
        locationValue -> LocationMapper.entityToModel(locationValue)
    ).collect(Collectors.toList());

    model.setLocations(locations);
    return model;
  }

  /**
   * model to entity.
   *
   * @param model
   * @return
   */
  public static ZoneEntity modelToEntity(ZoneDraft model) {
    ZoneEntity entity = new ZoneEntity();
    entity.setName(model.getName());
    entity.setDescription(model.getDescription());

    Set<LocationValue> locations = model.getLocations().parallelStream().map(
        location -> LocationMapper.modelToEntity(location)
    ).collect(Collectors.toSet());

    entity.setLocations(locations);
    return entity;
  }
}
