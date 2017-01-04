package io.reactivesw.order.cart.application.service;

import io.reactivesw.catalog.product.application.model.Price;
import io.reactivesw.catalog.product.application.model.ProductVariant;
import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.reactivesw.common.model.Money;
import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.cart.application.model.TaxedItemPrice;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umasuo on 16/12/12.
 */
@Service
public class LineItemService {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(LineItemService.class);

  /**
   * select Price for the item from variant prices.
   * This selection based on the currency, country
   *
   * @param item         LineItem
   * @param currencyCode currency code of this cart.
   * @param country      country of the cart
   */
  public void selectItemPrice(LineItem item, String currencyCode, String country) {
    LOG.debug("enter: LineItem: {}, currencyCode: {}, country: {}", item, currencyCode, country);
    ProductVariant variant = item.getProductVariant();
    if (variant != null) {
      List<Price> prices = variant.getPrices();

      Price selectedPrice = prices.parallelStream().filter(
          price -> {
            String savedCurrencyCode = price.getValue().getCurrencyCode();
            String savedCountry = price.getCountry();
            boolean onlyCurrency = StringUtils.equals(currencyCode, savedCurrencyCode)
                && country == null;
            boolean bothCurrencyAndCountry = StringUtils.equals(currencyCode, savedCurrencyCode)
                && StringUtils.equals(country, savedCountry);

            return onlyCurrency | bothCurrencyAndCountry;
          }
      ).findAny().orElse(null);

      item.setPrice(selectedPrice);
    }
  }


  /**
   * calculate LineItem price.
   *
   * @param item LineItem
   */
  public void calculateItemPrice(LineItem item) {
    if (item.getPrice() != null) {
      Money price = item.getPrice().getValue();
      int quantity = item.getQuantity();
      Money total = new Money();
      total.setCurrencyCode(price.getCurrencyCode());
      int totalPrice = price.getCentAmount() * quantity;
      total.setCentAmount(totalPrice);
      item.setTotalPrice(total);
      //for tax price, this should split to an single function
      this.calculateTaxedPrice(item);
    }
  }

  /**
   * calculate taxed price.
   *
   * @param item LineItem
   */
  private void calculateTaxedPrice(LineItem item) {

    TaxRate taxRate = item.getTaxRate();

    if (taxRate != null) {
      Money total = item.getTotalPrice();
      int totalPrice = total.getCentAmount();
      String currencyCode = total.getCurrencyCode();

      float tax = taxRate.getAmount();
      int taxPrice = totalPrice + Math.round(totalPrice * tax);
      Money totalNet = new Money();
      totalNet.setCentAmount(taxPrice);
      totalNet.setCurrencyCode(currencyCode);
      boolean isIncludedInPrice = taxRate.getIncludedInPrice();
      if (isIncludedInPrice) {
        total.setCentAmount(taxPrice);
      }
      TaxedItemPrice taxedItemPrice = new TaxedItemPrice();
      taxedItemPrice.setTotalNet(totalNet);
      taxedItemPrice.setTotalGross(total);
      item.setTaxedPrice(taxedItemPrice);
    }

  }
}
