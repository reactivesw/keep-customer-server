package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class CartDiscountsMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  @Override
  public void setAction(DiscountCodeEntity entity, UpdateAction action) {

  }
}
