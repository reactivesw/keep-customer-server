package io.reactivesw.order.cart.domain.service;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/14.
 */
@Service
public class ShippingInfoService {

  /**
   * calculate shipping total price.
   *
   * @param value          ShippingInfoValue
   * @param itemTotalPrice int
   * @return
   */
  public void calculateTotalPrice(ShippingInfoValue value, int itemTotalPrice) {
    MoneyEntity shippingPrice = value.getShippingRate().getPrice();
    MoneyEntity freeAbove = value.getShippingRate().getFreeAbove();
    int totalPrice = 0;

    if (itemTotalPrice < freeAbove.getCentAmount()) {
      totalPrice = shippingPrice.getCentAmount();
    }

    MoneyEntity price = value.getPrice();
    if (price == null) {
      price = new MoneyEntity();
      price.setCurrencyCode(shippingPrice.getCurrencyCode());
      value.setPrice(price);
    }

    price.setCentAmount(totalPrice);

    TaxRateValue taxRate = value.getTaxRate();
    if (taxRate != null && taxRate.getIncludedInPrice()) {
      int taxedPrice = totalPrice + Math.round(totalPrice * taxRate.getAmount());
      price.setCentAmount(taxedPrice);
    }

  }

}
