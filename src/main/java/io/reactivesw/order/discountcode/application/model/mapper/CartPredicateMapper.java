package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.action.SetCartPredicate;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class CartPredicateMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   * set cart predicate.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void setAction(DiscountCodeEntity entity, UpdateAction action) {
    SetCartPredicate predicate = (SetCartPredicate) action;
    //TODO how to receive the cart predicate
    entity.setCartPredicate(predicate.getCartPredicate());
  }
}
