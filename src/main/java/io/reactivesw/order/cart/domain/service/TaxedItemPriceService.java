package io.reactivesw.order.cart.domain.service;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.cart.domain.entity.value.TaxedItemPriceValue;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/14.
 */
@Service
public class TaxedItemPriceService {


  /**
   * @param currencyCode
   * @return
   */
  public TaxedItemPriceValue createWithCurrencyCode(String currencyCode) {

    TaxedItemPriceValue taxedItemPrice = new TaxedItemPriceValue();
    MoneyEntity net = new MoneyEntity();
    net.setCurrencyCode(currencyCode);
    MoneyEntity gross = new MoneyEntity();
    gross.setCurrencyCode(currencyCode);
    taxedItemPrice.setTotalNet(net);
    taxedItemPrice.setTotalGross(gross);
    return taxedItemPrice;
  }
}
