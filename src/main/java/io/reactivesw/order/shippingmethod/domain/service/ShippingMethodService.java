package io.reactivesw.order.shippingmethod.domain.service;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.mapper.ShippingMethodUpdateMapper;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.infrastructure.repository.ShippingMethodRepository;
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
    ShippingMethodEntity entity = this.repository.findOne(id);
    if (Objects.isNull(entity)) {
      throw new NotExistException("ShippingMethod not exist for id: " + id);
    }
    return entity;
  }

  /**
   * find all the shipping method that support the location.
   *
   * @param locationId
   * @return
   */
  public List<ShippingMethodEntity> getByLocation(String locationId) {
//    List<ShippingMethodEntity> allMethods = this.repository.findAll();

    //TODO
    return null;
  }

  /**
   * create shipping method.
   *
   * @param entity ShippingMethodEntity
   * @return ShippingMethodEntity
   */
  public ShippingMethodEntity createShippingMethod(ShippingMethodEntity entity) {
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

    ShippingMethodEntity valueInDb = this.getById(id);

    checkVersion(version, valueInDb.getVersion());

    actions.parallelStream().forEach(action -> ShippingMethodUpdateMapper.getMapper(action
        .getClass())
        .handle(valueInDb, action));

    return this.repository.save(valueInDb);
  }

  /**
   * delete shipping method by id.
   *
   * @param id shipping method id
   */
  public void deleteById(String id, Integer version) {
    ShippingMethodEntity valueInDb = this.getById(id);

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
      LOG.debug("ShippingMethod version is not correct. inputVersion:{}, savedVersion:{}",
          inputVersion, savedVersion);
      throw new ConflictException("ShippingMethod version is not correct.");
    }
  }

}
