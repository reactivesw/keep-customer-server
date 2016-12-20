package io.reactivesw.order.zone.application.controller;

import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.order.zone.application.model.mapper.ZoneMapper;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;
import io.reactivesw.order.zone.domain.service.ZoneService;
import io.reactivesw.route.ZoneRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/20.
 */
@RestController
public class ZoneController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ZoneController.class);

  /**
   * zone service.
   */
  @Autowired
  private transient ZoneService service;

  /**
   * get by id.
   *
   * @param id
   * @return Zone
   */
  @GetMapping(ZoneRouter.ZONE_WITH_ID)
  public Zone getZoneById(@PathVariable String id) {
    LOG.info("enter: id: {}", id);

    ZoneEntity entity = service.getById(id);

    LOG.info("exit: entity: {}", entity);
    return ZoneMapper.entityToModel(entity);
  }

  /**
   * get zone by location.
   *
   * @param country String
   * @param state   String
   * @return List of Zone
   */
  @GetMapping(ZoneRouter.ZONE_BASE_URL)
  public List<Zone> getByLocation(@RequestParam(name = "country") String country,
                                  @RequestParam(required = false, name = "state") String state) {
    List<ZoneEntity> zoneEntities = service.getByLocation(country, state);

    List<Zone> zones = zoneEntities.parallelStream().map(
        zoneEntity -> ZoneMapper.entityToModel(zoneEntity)
    ).collect(Collectors.toList());

    return zones;
  }
}
