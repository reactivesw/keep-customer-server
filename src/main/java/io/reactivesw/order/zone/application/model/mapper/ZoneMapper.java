package io.reactivesw.order.zone.application.model.mapper;

import io.reactivesw.order.zone.application.model.Location;
import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;

import java.util.List;
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
}
