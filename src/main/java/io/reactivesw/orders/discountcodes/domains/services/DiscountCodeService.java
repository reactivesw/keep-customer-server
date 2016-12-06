package io.reactivesw.orders.discountcodes.domains.services;

import io.reactivesw.common.exceptions.NotExistException;
import io.reactivesw.orders.discountcodes.domains.entities.DiscountCodeEntity;
import io.reactivesw.orders.discountcodes.repositories.DiscountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created by umasuo on 16/12/6.
 */
public class DiscountCodeService {

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
   * @param entity  DiscountCodeEntity
   * @return DiscountCodeEntity
   */

  public DiscountCodeEntity update(Integer version, DiscountCodeEntity entity) {

    this.getById(entity.getId());

    return this.discountCodeRepository.save(entity);
  }
}
