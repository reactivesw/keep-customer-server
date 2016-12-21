package io.reactivesw.order.zone.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.order.zone.application.model.mapper.ZoneMapper;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;
import io.reactivesw.order.zone.domain.service.ZoneService;
import io.reactivesw.route.ZoneRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  @ApiOperation("Get by id")
  @GetMapping(ZoneRouter.ZONE_WITH_ID)
  public Zone getZoneById(@PathVariable @ApiParam("zone id") String id) {
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
  @ApiOperation("Get by locatino: country & state")
  @GetMapping(ZoneRouter.ZONE_BASE_URL)
  public List<Zone> getByLocation(@RequestParam(name = "country") @ApiParam("country") String
                                      country,
                                  @RequestParam(required = false, name = "state")
                                  @ApiParam(value = "state", required = false) String state) {
    List<ZoneEntity> zoneEntities = service.getByLocation(country, state);

    List<Zone> zones = zoneEntities.parallelStream().map(
        zoneEntity -> ZoneMapper.entityToModel(zoneEntity)
    ).collect(Collectors.toList());

    return zones;
  }

  /**
   * update zone.
   *
   * @param id            zone id String
   * @param updateRequest update request
   * @return updated Zone
   */
  @ApiOperation("Update zone with id")
  @PutMapping(ZoneRouter.ZONE_WITH_ID)
  public Zone updateZone(@PathVariable @ApiParam("zone id") String id,
                         @RequestBody @ApiParam("update request with version & update actions")
                             UpdateRequest updateRequest) {
    LOG.info("enter: id: {}, UpdateRequest: {}", id, updateRequest);

    ZoneEntity entity = service.updateZone(id, updateRequest.getVersion(), updateRequest
        .getActions());

    LOG.info("exit: ZoneEntity: {}", entity);
    return ZoneMapper.entityToModel(entity);
  }

  /**
   * delete a zone.
   *
   * @param id      String
   * @param version Integer
   */
  @ApiOperation("delete zone with id & version")
  @DeleteMapping(ZoneRouter.ZONE_WITH_ID)
  public void deleteZone(@PathVariable @ApiParam("zone id") String id,
                         @RequestParam @ApiParam("version") Integer version) {
    LOG.info("enter: id: {}, version: {}", id, version);

    service.deleteById(id, version);
  }
}
