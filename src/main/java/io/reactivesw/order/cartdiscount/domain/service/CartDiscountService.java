package io.reactivesw.order.cartdiscount.domain.service;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import io.reactivesw.order.cartdiscount.infrastructure.repository.CartDiscountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/9.
 */
@Service
public class CartDiscountService {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartDiscountService.class);

  /**
   * repository.
   */
  private transient CartDiscountRepository repository;

  /**
   * get cart discount by id.
   *
   * @param id String
   * @return cart discount.
   */
  public CartDiscountEntity getById(String id) {
    LOG.debug("enter: id: {}", id);
    CartDiscountEntity entity = this.repository.findOne(id);

    if (entity == null) {
      LOG.warn("The cart discount do not exist, id : {}", id);
      throw new NotExistException("The cart discount do not exist, id:" + id);
    }

    LOG.debug("exit: CartDiscountEntity: {}", entity);
    return entity;
  }

  /**
   * create cart discount.
   *
   * @param value cart discount
   * @return cart discount
   */
  public CartDiscountEntity create(CartDiscountEntity value) {
    LOG.debug("enter: value: {}", value);
    return this.repository.save(value);
  }



}
