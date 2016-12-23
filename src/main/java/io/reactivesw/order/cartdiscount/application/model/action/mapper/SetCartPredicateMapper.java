package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.SetCartPredicate;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetCartPredicateMapper implements CartDiscountUpdateMapper {


  /**
   * set the cart predicate.
   *
   * @param entity CartDiscountEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {
    SetCartPredicate setCartPredicate = (SetCartPredicate) action;

    String predicate = setCartPredicate.getCartPredicate();
    if (StringUtils.isNotBlank(predicate)) {
      entity.setCartPredicate(predicate);
    }

  }
}
