package io.reactivesw.order.cartdiscount.application.model.mapper;

import io.reactivesw.order.cartdiscount.application.model.CartDiscountTarget;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountTargetValue;

/**
 * Created by umasuo on 16/12/22.
 */
public class CartDiscountTargetMapper {

  public static CartDiscountTarget entityToModel(CartDiscountTargetValue entity) {
    CartDiscountTarget model = null;
    if (entity != null) {
      model = new CartDiscountTarget();
      model.setPredicate(entity.getPredicate());
      model.setType(entity.getType());
    }
    return model;
  }

  public static CartDiscountTargetValue modelToEntity(CartDiscountTarget model) {
    CartDiscountTargetValue entity = null;
    if (model != null) {
      entity = new CartDiscountTargetValue();
      entity.setPredicate(model.getPredicate());
      entity.setType(model.getType());
    }
    return entity;
  }
}
