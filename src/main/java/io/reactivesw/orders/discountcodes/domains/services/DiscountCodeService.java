package io.reactivesw.orders.discountcodes.domains.services;

import io.reactivesw.common.exceptions.NotExistException;
import io.reactivesw.orders.discountcodes.domains.entities.DiscountCodeEntity;
import io.reactivesw.orders.discountcodes.repositories.DiscountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
    return this.discountCodeRepository.save(sample);
  }
}
