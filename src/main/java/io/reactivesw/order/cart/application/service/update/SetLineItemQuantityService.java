package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetLineItemQuantity;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by umasuo on 16/12/16.
 */
@Service(value = CartUpdateActionUtils.SET_LINE_ITEM_QUANTITY)
public class SetLineItemQuantityService extends CartUpdateService {

  /**
   * change line item quantity.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity entity, UpdateAction action) {
    SetLineItemQuantity quantityAction = (SetLineItemQuantity) action;
    Integer quantity = quantityAction.getQuantity();
    String lineItemId = quantityAction.getLineItemId();

    LineItemValue item = this.getLineItem(entity, lineItemId);
    if (quantity == null || quantity == 0) {
      entity.getLineItems().remove(item);
    } else {
      item.setQuantity(quantity);
    }
  }

  /**
   * get line item from the cart.
   *
   * @param cart       cart
   * @param lineItemId line item id
   * @return LineItemValue
   */
  private LineItemValue getLineItem(CartEntity cart, String lineItemId) {
    Set<LineItemValue> lineItems = cart.getLineItems();
    LineItemValue item = lineItems.stream().filter(
        tmpItem -> StringUtils.equals(tmpItem.getId(), lineItemId)
    ).findAny().orElse(null);
    if (item == null) {
      throw new NotExistException("LineItem not existing when for cartId: " + cart.getId() +
          "lineItemId:" + lineItemId);
    }
    return item;
  }
}
