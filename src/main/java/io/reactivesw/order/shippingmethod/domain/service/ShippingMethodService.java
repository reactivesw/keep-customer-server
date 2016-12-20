package io.reactivesw.order.shippingmethod.domain.service;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.mapper.ShippingMethodUpdateMapper;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.entity.ZoneRateValue;
import io.reactivesw.order.shippingmethod.infrastructure.repository.ShippingMethodRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/8.
 */
@Service
public class ShippingMethodService {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ShippingMethodService.class);

  /**
   * repository.
   */
  @Autowired
  private transient ShippingMethodRepository repository;


  /**
   * get shipping method by id.
   *
   * @param id String
   * @return ShippingMethodEntity
   */
  public ShippingMethodEntity getById(String id) {
    LOG.debug("enter: shipping method id: {}", id);

    ShippingMethodEntity entity = this.repository.findOne(id);
    if (Objects.isNull(entity)) {
      LOG.warn("exception: shipping method not found, id : {}", id);
      throw new NotExistException("ShippingMethod not exist for id: " + id);
    }

    LOG.debug("exit: shipping method : {}", entity);
    return entity;
  }

  /**
   * find all the shipping method that support the location.
   * TODO use cache
   *
   * @param locationId String
   * @return ShippingMethodEntity
   */
  public List<ShippingMethodEntity> getByLocation(String locationId) {
    LOG.debug("enter: locationId: {}", locationId);
    List<ShippingMethodEntity> allMethods = this.repository.findAll();

    LOG.debug("data: all shipping methods: {}", allMethods);

    List<ShippingMethodEntity> methods = allMethods.parallelStream().filter(
        shippingMethodEntity -> {
          Set<ZoneRateValue> zoneRateValues = shippingMethodEntity.getZoneRates();
          Optional<ZoneRateValue> optional = zoneRateValues.parallelStream().filter(
              zoneRateValue -> StringUtils.equals(zoneRateValue.getZone(), locationId)
          ).findFirst();

          boolean result = false;
          if (optional.isPresent()) {
            result = true;
          }
          return result;
        }
    ).collect(Collectors.toList());

    LOG.debug("exit: selected methods: {}", methods);
    return methods;
  }

  /**
   * create shipping method.
   *
   * @param entity ShippingMethodEntity
   * @return ShippingMethodEntity
   */
  public ShippingMethodEntity createShippingMethod(ShippingMethodEntity entity) {
    LOG.debug("enter: sample shipping method for save: {}", entity);
    return this.repository.save(entity);
  }

  /**
   * update Zone with update actions.
   *
   * @param id      String
   * @param version version
   * @param actions UpdateAction list
   * @return ZoneEntity
   */
  public ShippingMethodEntity update(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter: id: {}, version: {}, actions: {}", id, version, actions);

    ShippingMethodEntity valueInDb = this.getById(id);

    LOG.debug("data: shipping method in db: {}", valueInDb);

    checkVersion(version, valueInDb.getVersion());

    actions.parallelStream().forEach(
        action -> ShippingMethodUpdateMapper.getMapper(action.getClass()).handle(valueInDb, action)
    );

    LOG.debug("exit: updated shipping method: {}", valueInDb);
    return this.repository.save(valueInDb);
  }

  /**
   * delete shipping method by id.
   *
   * @param id shipping method id
   */
  public void deleteById(String id, Integer version) {
    LOG.debug("enter: id: {}, version: {}", id, version);

    ShippingMethodEntity valueInDb = this.getById(id);
    LOG.debug("data: shipping method in db: {}", valueInDb);

    checkVersion(version, valueInDb.getVersion());

    this.repository.delete(id);
  }

  /**
   * check the version of the discount.
   *
   * @param inputVersion Integer
   * @param savedVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer savedVersion) {
    if (!Objects.equals(inputVersion, savedVersion)) {
      LOG.warn("wrong version warning: inputVersion: {}, savedVersion: {}",
          inputVersion, savedVersion);
      throw new ConflictException("ShippingMethod version is not correct.");
    }
  }

}
