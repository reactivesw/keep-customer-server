package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.LineItemDraft;
import io.reactivesw.order.cart.application.model.action.AddLineItem;
import io.reactivesw.order.cart.application.model.mapper.LineItemMapper;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/16.
 */
@Service
public class AddLineItemService extends CartUpdateService {

  /**
   * handle add line item action.
   *
   * @param entity CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity entity, UpdateAction action) {
    LineItemValue data = this.getData((AddLineItem) action);

    LineItemValue value = entity.getLineItems().parallelStream().filter(
        lineItemValue -> lineItemValue.getProductId().equals(data.getProductId())
            && lineItemValue.getVariant() == data.getVariant()
    ).findAny().orElse(null);

    if (value == null) {
      entity.getLineItems().add(data);
    } else {
      //if exist, then just add the quantity
      value.setQuantity(value.getQuantity() + data.getQuantity());
    }
  }

  /**
   * get data from action.
   *
   * @param action AddLineItem
   * @return LineItemValue
   */
  private LineItemValue getData(AddLineItem action) {
    return LineItemMapper.modelToEntity((LineItemDraft) action);
  }
}
