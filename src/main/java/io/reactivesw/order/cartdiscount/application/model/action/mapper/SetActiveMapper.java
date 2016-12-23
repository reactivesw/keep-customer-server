package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import io.reactivesw.order.discountcode.application.model.action.SetActive;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetActiveMapper implements CartDiscountUpdateMapper {

  /**
   * set the active.
   *
   * @param entity CartDiscountEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {
    SetActive setActive = (SetActive) action;
    if (setActive.getActive() != null) {
      entity.setActive(setActive.getActive());
    }
  }
}
