package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;
import io.reactivesw.order.cart.domain.service.LineItemService;
import io.reactivesw.order.cart.domain.service.ShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by umasuo on 16/12/16.
 */
@Service
public class RecalculateService extends CartUpdateService {

  /**
   * LineItem service.
   */
  @Autowired
  private transient LineItemService lineItemService;

  /**
   * custom item service.
   */
//  @Autowired
//  private transient CustomLineItemService customLineItemService;

  /**
   * shipping info service.
   */
  @Autowired
  private transient ShippingInfoService shippingInfoService;

  /**
   * recalculate cart.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity entity, UpdateAction action) {
    this.calculate(entity);
  }

  /**
   * calculate cart price.
   * TODO split the method.
   *
   * @param cart CartEntity
   */
  public void calculate(CartEntity cart) {
    int lineItemTotalPrice = cart.getLineItems().parallelStream().mapToInt(
        lineItemValue -> {
          lineItemService.calculateTotalPrice(lineItemValue);
          return lineItemValue.getTotalPrice().getCentAmount();
        }
    ).sum();

//    int customItemTotalPrice = cart.getCustomLineItems().parallelStream().mapToInt(
//        customLineItemValue -> {
//          customLineItemService.calculateTotalPrice(customLineItemValue);
//          return customLineItemValue.getTotalPrice().getCentAmount();
//        }
//    ).sum();

    ShippingInfoValue shippingInfo = cart.getShippingInfo();
    shippingInfoService.calculateTotalPrice(shippingInfo, lineItemTotalPrice);
    int shippingTotalPrice = shippingInfo.getPrice().getCentAmount();

    //TODO use discount to calculate the cart price
    int totalPrice = lineItemTotalPrice + shippingTotalPrice;

    MoneyEntity cartTotalPrice = cart.getTotalPrice();
    if (Objects.isNull(cartTotalPrice)) {
      cartTotalPrice = new MoneyEntity();
      cart.setTotalPrice(cartTotalPrice);
    }
    cartTotalPrice.setCentAmount(totalPrice);
  }
}
