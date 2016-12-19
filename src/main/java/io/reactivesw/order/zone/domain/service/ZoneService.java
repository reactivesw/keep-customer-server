package io.reactivesw.order.zone.domain.service;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.zone.application.model.mapper.ZoneUpdateMapper;
import io.reactivesw.order.zone.domain.entity.ZoneEntity;
import io.reactivesw.order.zone.infrastructure.repository.ZoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by umasuo on 16/12/8.
 */
@Service
public class ZoneService {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ZoneService.class);

  /**
   * zone repository.
   */
  @Autowired
  private transient ZoneRepository zoneRepository;

  /**
   * get zone by id.
   *
   * @param id String
   * @return ZoneEntity
   */
  public ZoneEntity getById(String id) {
    ZoneEntity entity = this.zoneRepository.findOne(id);
    if (Objects.isNull(entity)) {
      throw new NotExistException("Zone not exist for id:" + id);
    }
    return entity;
  }

  /**
   * create zone.
   *
   * @param entity Zone Entity
   * @return Zone entity
   */
  public ZoneEntity createZone(ZoneEntity entity) {
    return this.zoneRepository.save(entity);
  }

  /**
   * update Zone with update actions.
   *
   * @param id      String
   * @param version version
   * @param actions UpdateAction list
   * @return ZoneEntity
   */
  public ZoneEntity updateZone(String id, Integer version, List<UpdateAction> actions) {

    ZoneEntity valueInDb = this.getById(id);

    checkVersion(version, valueInDb.getVersion());

    actions.parallelStream().forEach(action -> ZoneUpdateMapper.getMapper(action.getClass())
        .handle(valueInDb, action));

    return this.zoneRepository.save(valueInDb);
  }

  /**
   * delete zone by id.
   *
   * @param id      String
   * @param version Integer.
   */
  public void deleteById(String id, Integer version) {

    ZoneEntity valueInDb = this.getById(id);

    checkVersion(version, valueInDb.getVersion());

    this.zoneRepository.delete(id);
  }

  /**
   * check the version of the discount.
   *
   * @param inputVersion Integer
   * @param savedVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer savedVersion) {
    if (!Objects.equals(inputVersion, savedVersion)) {
      LOG.debug("Zone version is not correct. inputVersion:{}, savedVersion:{}",
          inputVersion, savedVersion);
      throw new ConflictException("Zone version is not correct.");
    }
  }
}
