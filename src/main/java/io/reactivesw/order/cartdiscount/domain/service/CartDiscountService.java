package io.reactivesw.order.cartdiscount.domain.service;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.mapper.CartDiscountUpdateMapper;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import io.reactivesw.order.cartdiscount.infrastructure.repository.CartDiscountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

  /**
   * update cart discount.
   *
   * @param id      String
   * @param version Integer
   * @param actions actions
   * @return CartDiscountEntity
   */
  public CartDiscountEntity update(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter: id: {}, version: {}, actions: {}", id, version, actions);

    CartDiscountEntity valueInDb = this.getById(id);

    LOG.debug("data: cart discount in db: {}", valueInDb);

    checkVersion(version, valueInDb.getVersion());

    actions.parallelStream().forEach(
        action -> CartDiscountUpdateMapper.getMapper(action.getClass()).handle(valueInDb, action)
    );

    LOG.debug("exit: updated cart discount: {}", valueInDb);
    return this.repository.save(valueInDb);
  }


  /**
   * delete cart discount by id.
   *
   * @param id      cart discount id
   * @param version Integer
   */
  public void deleteById(String id, Integer version) {
    LOG.debug("enter: id: {}, version: {}", id, version);

    CartDiscountEntity valueInDb = this.getById(id);
    LOG.debug("data: cart discount in db: {}", valueInDb);

    checkVersion(version, valueInDb.getVersion());

    this.repository.delete(id);
  }

  /**
   * check the version.
   *
   * @param inputVersion Integer
   * @param savedVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer savedVersion) {
    if (!Objects.equals(inputVersion, savedVersion)) {
      LOG.warn("wrong version warning: inputVersion: {}, savedVersion: {}",
          inputVersion, savedVersion);
      throw new ConflictException("CartDiscount version is not correct.");
    }
  }

}
