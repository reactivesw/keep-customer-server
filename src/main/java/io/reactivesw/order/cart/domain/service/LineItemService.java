package io.reactivesw.order.cart.domain.service;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.domain.entity.value.PriceValue;
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue;
import io.reactivesw.order.cart.domain.entity.value.TaxedItemPriceValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
   * price service.
   */
  @Autowired
  private transient PriceService priceService;

  /**
   * taxed item price.
   */
  @Autowired
  private transient TaxedItemPriceService taxedItemPriceService;


  /**
   * REST template.
   */
//  private RestTemplate restTemplate = new RestTemplateBuilder().build();

//  @Autowired
//  private ApplicationConfig config;

  /**
   * fill item's product data for this snapshot.
   * call product service, and then
   *
   * @param item LineItemValue
   */
  public void fillProduct(LineItemValue item) {
    //TODO get info from product service.
    LOG.debug("Get info from product service.");
//    ProductData product = restTemplate.getForObject(
//        Router.CATEGORY_WITH_ID,
//        ProductData.class
//        );
    //select an price for the item.
  }

  /**
   * calculate the item's price.
   *
   * @param item LineItem.
   */
  public void calculateTotalPrice(LineItemValue item) {

    //TODO check the money currency, and then calculate the total price.
    PriceValue price = item.getPrice();
    Integer quantity = item.getQuantity();
    Integer totalPrice = priceService.getPriceValue(price).getCentAmount() * quantity;
    //TODO use the discounted price
    TaxRateValue taxRateValue = item.getTaxRate();
    if (taxRateValue != null && taxRateValue.getIncludedInPrice()) {
      //TODO should we check the round-off ?
      LOG.debug("Add tax into total price, itemId: {}", item.getId());
      totalPrice += Math.round(totalPrice * item.getTaxRate().getAmount());
    }

    MoneyEntity total = item.getTotalPrice();
    if (Objects.isNull(total)) {
      total = new MoneyEntity();
      total.setCurrencyCode(price.getValue().getCurrencyCode());
      item.setTotalPrice(total);
    }
    total.setCentAmount(totalPrice);
  }

  /**
   * calculate the item's taxed price.
   *
   * @param item LineItemValue.
   */
  public void calculateTaxedPrice(LineItemValue item) {
    PriceValue price = item.getPrice();
    int quantity = item.getQuantity();
    int totalPrice = priceService.getPriceValue(price).getCentAmount() * quantity;
    //TODO should we check the round-off ?
    int taxedPrice = totalPrice + Math.round(totalPrice * item.getTaxRate().getAmount());

    TaxedItemPriceValue taxedItemPrice = item.getTaxedPrice();
    if (Objects.isNull(taxedItemPrice)) {
      taxedItemPrice = taxedItemPriceService.createWithCurrencyCode(price.getValue()
          .getCurrencyCode());
      item.setTaxedPrice(taxedItemPrice);
    }

    item.getTaxedPrice().getTotalNet().setCentAmount(totalPrice);
    item.getTaxedPrice().getTotalGross().setCentAmount(taxedPrice);
  }


}
