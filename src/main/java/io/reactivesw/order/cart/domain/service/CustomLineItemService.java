package io.reactivesw.order.cart.domain.service;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.cart.domain.entity.value.CustomLineItemValue;
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue;
import io.reactivesw.order.cart.domain.entity.value.TaxedItemPriceValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by umasuo on 16/12/13.
 */
@Service
public class CustomLineItemService {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CustomLineItemService.class);

  /**
   * taxed item price.
   */
  @Autowired
  private transient TaxedItemPriceService taxedItemPriceService;

  /**
   * calculate the item's price.
   *
   * @param item CustomLineItemValue.
   */
  public void calculateTotalPrice(CustomLineItemValue item) {

    MoneyEntity money = item.getMoney();
    int quantity = item.getQuantity();
    //TODO use the discounted price
    int totalPrice = money.getCentAmount() * quantity;

    // calculate tax
    TaxRateValue taxRateValue = item.getTaxRate();
    if (taxRateValue != null && taxRateValue.getIncludedInPrice()) {
      //TODO should we check the round-off ?
      LOG.debug("Add tax into total price, itemId: {}", item.getId());
      totalPrice += Math.round(totalPrice * item.getTaxRate().getAmount());
    }
    // set total price
    MoneyEntity total = item.getTotalPrice();
    if (Objects.isNull(total)) {
      total = new MoneyEntity();
      total.setCurrencyCode(money.getCurrencyCode());
      item.setTotalPrice(total);
    }
    total.setCentAmount(totalPrice);
  }

  /**
   * calculate taxed price.
   *
   * @param item CustomLineItemValue
   */
  public void calculateTaxedPrice(CustomLineItemValue item) {

    TaxRateValue taxRateValue = item.getTaxRate();
    if (null != taxRateValue) {
      MoneyEntity money = item.getMoney();
      int quantity = item.getQuantity();
      //TODO use the discounted price
      int totalPrice = money.getCentAmount() * quantity;
      //TODO should we check the round-off ?
      LOG.debug("Add tax into total price, itemId: {}", item.getId());
      int taxedPrice = totalPrice + Math.round(totalPrice * item.getTaxRate().getAmount());

      TaxedItemPriceValue taxedItemPrice = item.getTaxedPrice();
      if (Objects.isNull(taxedItemPrice)) {
        taxedItemPrice = taxedItemPriceService.createWithCurrencyCode(money.getCurrencyCode());
        item.setTaxedPrice(taxedItemPrice);
      }
      item.getTaxedPrice().getTotalNet().setCentAmount(totalPrice);
      item.getTaxedPrice().getTotalGross().setCentAmount(taxedPrice);
    }

  }

}
