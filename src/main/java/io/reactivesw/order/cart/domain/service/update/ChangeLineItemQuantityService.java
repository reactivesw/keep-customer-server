package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetLineItemQuantity;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Created by umasuo on 16/12/16.
 */
@Service
public class ChangeLineItemQuantityService extends CartUpdateService {

  /**
   * recalculate service.
   */
  @Autowired
  private transient RecalculateService recalculateService;

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

    Set<LineItemValue> lineItems = entity.getLineItems();

    LineItemValue itemValue = this.getLineItem(entity, lineItemId);

    if (quantity == null || quantity == 0) {
      lineItems.remove(itemValue);
    } else {
      itemValue.setQuantity(quantity);
    }
    recalculateService.calculate(entity);
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
    Optional<LineItemValue> item = lineItems.stream().filter(tmpItem -> tmpItem.getId()
        == lineItemId).findFirst();
    if (!item.isPresent()) {
      throw new NotExistException("LineItem not existing when for cartId: " + lineItemId +
          "lineItemId:" + lineItemId);
    }
    return item.get();
  }
}
