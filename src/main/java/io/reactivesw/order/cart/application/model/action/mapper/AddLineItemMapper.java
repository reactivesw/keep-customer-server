package io.reactivesw.order.cart.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.AddLineItem;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;

/**
 * Created by umasuo on 16/12/15.
 */
public class AddLineItemMapper implements CartUpdateMapper {

  @Override
  public void setAction(CartEntity entity, UpdateAction action) {
    //TODO just add time.
//    AddLineItem addLineItem = (AddLineItem)action;
  }
}
