package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.SetRequiresDiscountCode;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetRequiresDiscountCodeMapper implements CartDiscountUpdateMapper {

  /**
   * set requires discount code.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {

    SetRequiresDiscountCode setCode = (SetRequiresDiscountCode) action;

    if (setCode.getRequiresDiscountCode() != null) {
      entity.setRequiresDiscountCode(setCode.getRequiresDiscountCode());
    }

  }
}
