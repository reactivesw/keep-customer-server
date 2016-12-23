package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.SetValidFrom;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetValidFromMapper implements CartDiscountUpdateMapper {

  /**
   * set valid from date.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {

    SetValidFrom setValidFrom = (SetValidFrom) action;

    if (setValidFrom.getValidFrom() != null) {
      entity.setValidFrom(setValidFrom.getValidFrom());
    }
  }
}
