package io.reactivesw.order.cartdiscount.application.service;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.CartDiscount;
import io.reactivesw.order.cartdiscount.application.model.mapper.CartDiscountMapper;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import io.reactivesw.order.cartdiscount.domain.service.CartDiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umasuo on 16/12/22.
 */
@Service
public class CartDiscountApplication {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartDiscountApplication.class);

  /**
   * cart discount service.
   */
  @Autowired
  private transient CartDiscountService service;

  /**
   * get by id, and create all the reference.
   *
   * @param id String
   * @return CartDiscountEntity
   */
  public CartDiscount getById(String id) {
    LOG.debug("enter: id: {}", id);
    CartDiscountEntity entity = service.getById(id);
    //TODO use the predicate to find all the resource addressed

    LOG.debug("exit: value: {}", entity);
    return CartDiscountMapper.entityToModel(entity);
  }

  /**
   * create cart discount from draft.
   *
   * @param draft CartDiscountEntity
   * @return CartDiscount
   */
  public CartDiscount createCartDiscount(CartDiscountEntity draft) {
    LOG.debug("enter: draft: {}", draft);

    CartDiscountEntity entity = service.create(draft);

    CartDiscount discount = CartDiscountMapper.entityToModel(entity);
    //TODO use the predicate to find all the resource addressed

    LOG.debug("enter: value: {}", discount);
    return discount;
  }

  /**
   * update cart discount.
   *
   * @param id      String
   * @param version Integer
   * @param actions actions
   * @return CartDiscount
   */
  public CartDiscount update(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter: id: {}, version: {}, actions: {}", id, version, actions);

    CartDiscountEntity entity = service.update(id, version, actions);

    CartDiscount discount = CartDiscountMapper.entityToModel(entity);
    //TODO use the predicate to find all the resource addressed

    LOG.debug("enter: value: {}", discount);
    return discount;
  }
}
