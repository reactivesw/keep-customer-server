package io.reactivesw.order.cart.application.service;

import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.reactivesw.common.model.Money;
import io.reactivesw.order.cart.application.model.ShippingInfo;
import io.reactivesw.order.cart.application.model.TaxedItemPrice;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/14.
 */
@Service
public class ShippingInfoService {

  /**
   * calculate the shipping price.
   *
   * @param shippingInfo   ShippingInfo in the cart
   * @param currencyCode   current code
   * @param itemTotalPrice itemTotalPrice
   */
  public void calculateShippingPrice(ShippingInfo shippingInfo, String currencyCode, int
      itemTotalPrice) {
    if (shippingInfo != null && shippingInfo.getShippingRate() != null) {
      Money shippingPrice = new Money();
      shippingPrice.setCurrencyCode(currencyCode);
      shippingPrice.setCentAmount(0);

      //set the price
      ShippingRate shippingRate = shippingInfo.getShippingRate();
      Money freeAbove = shippingRate.getFreeAbove();

      if (freeAbove == null || freeAbove.getCentAmount() > itemTotalPrice) {
        shippingPrice.setCentAmount(shippingRate.getPrice().getCentAmount());
      }
      shippingInfo.setPrice(shippingPrice);

      this.calculateTaxedPrice(shippingInfo, currencyCode);
    }
  }

  /**
   * calculate taxed price.
   *
   * @param shippingInfo ShippingInfo
   * @param currencyCode String
   */
  private void calculateTaxedPrice(ShippingInfo shippingInfo, String currencyCode) {
    //calculate the taxed price
    TaxRate taxRate = shippingInfo.getTaxRate();
    if (taxRate != null) {
      Money shippingPrice = shippingInfo.getPrice();

      boolean includeInPrice = taxRate.getIncludedInPrice();
      float amount = taxRate.getAmount();
      Money taxedPrice = new Money();
      taxedPrice.setCurrencyCode(currencyCode);
      int shippingAmount = shippingPrice.getCentAmount();
      int taxed = shippingAmount + Math.round(shippingAmount * amount);
      taxedPrice.setCentAmount(taxed);
      if (includeInPrice) {
        shippingPrice.setCentAmount(taxed);
      }
      TaxedItemPrice taxedItemPrice = new TaxedItemPrice();
      taxedItemPrice.setTotalNet(shippingPrice);
      taxedItemPrice.setTotalGross(taxedPrice);
      shippingInfo.setTaxedPrice(taxedItemPrice);
    }
  }
}
