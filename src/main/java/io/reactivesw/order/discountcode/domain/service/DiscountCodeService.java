package io.reactivesw.order.discountcode.domain.service;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.ImmutableException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.mapper.DiscountCodeUpdateMapper;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;
import io.reactivesw.order.discountcode.infrastructure.repository.DiscountCodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by umasuo on 16/12/6.
 */
public class DiscountCodeService {

  /**
   * LOG.
   */
  private static final Logger LOG = LoggerFactory.getLogger(DiscountCodeService.class);

  /**
   * repository.
   */
  @Autowired
  private transient DiscountCodeRepository discountCodeRepository;

  /**
   * get discount code by id.
   *
   * @param id String uuid
   * @return DiscountCodeEntity
   */
  public DiscountCodeEntity getById(String id) {

    DiscountCodeEntity entity = this.discountCodeRepository.findOne(id);

    if (entity == null) {
      throw new NotExistException("DiscountCode not exist.");
    }
    return entity;
  }

  /**
   * create an new discount code.
   *
   * @param sample DiscountCodeEntity
   * @return DiscountCodeEntity created
   */
  public DiscountCodeEntity createDiscountCode(DiscountCodeEntity sample) {
    sample.setCode(UUID.randomUUID().toString());
    return this.discountCodeRepository.save(sample);
  }

  /**
   * update discount code entity.
   *
   * @param version Integer
   * @param actions List<UpdateAction> list of UpdateActions
   * @return DiscountCodeEntity
   */

  public DiscountCodeEntity update(String id, Integer version, List<UpdateAction> actions) {

    DiscountCodeEntity valueInDb = this.getById(id);
    if (valueInDb.getActive()) {
      LOG.debug("Active DiscountCode can not be changed, id:{}", id);
      throw new ImmutableException("Active DiscountCode can not be changed");
    }
    checkVersion(version, valueInDb.getVersion());

    actions.parallelStream().forEach(action -> DiscountCodeUpdateMapper.getMapper(action.getClass())
        .setAction(valueInDb, action));

    return this.discountCodeRepository.save(valueInDb);
  }

  /**
   * check the version of the discount.
   *
   * @param inputVersion Integer
   * @param savedVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer savedVersion) {
    if (!Objects.equals(inputVersion, savedVersion)) {
      LOG.debug("DiscountCode version is not correct. inputVersion:{}, savedVersion:{}",
          inputVersion, savedVersion);
      throw new ConflictException("DiscountCode version is not correct.");
    }
  }
}
