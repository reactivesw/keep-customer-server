package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.action.SetActive;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class ActiveMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void setAction(DiscountCodeEntity entity, UpdateAction action) {
    entity.setActive(((SetActive) action).getActive());
  }
}
