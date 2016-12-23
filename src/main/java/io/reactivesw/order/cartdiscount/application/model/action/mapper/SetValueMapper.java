package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.CartDiscountValue;
import io.reactivesw.order.cartdiscount.application.model.action.SetValue;
import io.reactivesw.order.cartdiscount.application.model.mapper.CartDiscountValueMapper;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetValueMapper implements CartDiscountUpdateMapper {

  /**
   * set value;
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {

    SetValue setValue = (SetValue) action;

    CartDiscountValue value = setValue.getValue();
    if (value != null) {
      entity.setValue(CartDiscountValueMapper.modelToEntity(value));
    }
  }
}
