package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.CartDiscountTarget;
import io.reactivesw.order.cartdiscount.application.model.action.SetTarget;
import io.reactivesw.order.cartdiscount.application.model.mapper.CartDiscountTargetMapper;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetTargetMapper implements CartDiscountUpdateMapper {

  /**
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {

    SetTarget setTarget = (SetTarget) action;
    CartDiscountTarget target = setTarget.getTarget();

    if (target != null) {
      entity.setTarget(CartDiscountTargetMapper.modelToEntity(target));
    }
  }
}
