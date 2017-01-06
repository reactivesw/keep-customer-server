package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.RemoveLineItem;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by umasuo on 16/12/16.
 */
@Service(value = CartUpdateActionUtils.REMOVE_LINE_ITEM)
public class RemoveLineItemService extends CartUpdateService {

  /**
   * remove LineItemService.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity entity, UpdateAction action) {

    RemoveLineItem removeLineItem = (RemoveLineItem) action;
    String lineItemId = removeLineItem.getLineItemId();
    Integer quantity = removeLineItem.getQuantity();

    Set<LineItemValue> lineItems = entity.getLineItems();

    LineItemValue itemValue = this.getLineItem(lineItems, lineItemId);
    Integer currentQuantity = itemValue.getQuantity();

    if (quantity == null || currentQuantity <= quantity) {
      lineItems.remove(itemValue);
    } else {
      Integer remainQuantity = currentQuantity - quantity;
      itemValue.setQuantity(remainQuantity);
    }
    entity.setLineItems(lineItems);
  }

  /**
   * get line item from the cart.
   *
   * @param lineItems  cart
   * @param lineItemId line item id
   * @return LineItemValue
   */
  private LineItemValue getLineItem(Set<LineItemValue> lineItems, String lineItemId) {

    LineItemValue item = lineItems.stream().filter(
        tmpItem -> StringUtils.equals(tmpItem.getId(), lineItemId)
    ).findAny().orElse(null);

    if (item == null) {
      throw new NotExistException("Removing not existing line item.");
    }
    return item;
  }
}
