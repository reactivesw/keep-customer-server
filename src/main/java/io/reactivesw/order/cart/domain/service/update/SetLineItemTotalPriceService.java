package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.application.model.ExternalLineItemTotalPrice;
import io.reactivesw.order.cart.application.model.action.SetLineItemTotalPrice;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cartdiscount.infrastructure.enums.LineItemPriceMode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Sets the totalPrice and price of the line item and changes the priceMode of the line item to
 * ExternalTotal. If the external total price of the line item was already set and the
 * externalTotalPrice field of this update action is not given, the external price is unset and
 * the line item price mode is set back to Platform. Although both price and totalPrice are set
 * with this update action, only totalPrice will be used to calculate the total price of the cart.
 * Created by umasuo on 16/12/19.
 */
public class SetLineItemTotalPriceService extends CartUpdateService {

  /**
   * calculator.
   */
  @Autowired
  private transient RecalculateService recalculateService;

  /**
   * set the line item's price.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetLineItemTotalPrice setLineItemTotalPrice = (SetLineItemTotalPrice) action;
    String lineItemId = setLineItemTotalPrice.getLineItemId();

    ExternalLineItemTotalPrice externalPrice = setLineItemTotalPrice.getExternalTotalPrice();
    Money price = externalPrice.getPrice();
    Money totalPrice = externalPrice.getTotalPrice();

    LineItemValue lineItem = this.getLineItem(cart, lineItemId);

    if (lineItem.getPriceMode() == LineItemPriceMode.ExternalTotal) {
      if (totalPrice == null) {
        lineItem.setPriceMode(LineItemPriceMode.Platform);
      } else {
        lineItem.setTotalPrice(MoneyMapper.modelToEntity(totalPrice));
      }
    } else {
      lineItem.setPriceMode(LineItemPriceMode.ExternalTotal);
      lineItem.getPrice().setValue(MoneyMapper.modelToEntity(price));
      if (totalPrice == null) {

        Integer total = lineItem.getQuantity() * price.getCentAmount();
        lineItem.getTotalPrice().setCentAmount(total);

      } else {
        lineItem.setTotalPrice(MoneyMapper.modelToEntity(totalPrice));
      }
    }

    recalculateService.calculate(cart);
  }

  private LineItemValue getLineItem(CartEntity cart, String lineItemId) {
    Optional<LineItemValue> optional = cart.getLineItems().parallelStream().filter(
        lineItemValue -> {
          boolean result = false;
          if (StringUtils.equals(lineItemId, lineItemValue.getId())) {
            result = true;
          }
          return result;
        }
    ).findFirst();

    if (!optional.isPresent()) {
      throw new NotExistException("LineItem not exist in the cart.");
    }
    return optional.get();
  }
}
