package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.SetValidUntil;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetValidUntilMapper implements CartDiscountUpdateMapper {

  /**
   * set valid until date.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {

    SetValidUntil setValidUntil = (SetValidUntil) action;

    if (setValidUntil.getValidUntil() != null) {
      entity.setValidUntil(setValidUntil.getValidUntil());
    }
  }
}
