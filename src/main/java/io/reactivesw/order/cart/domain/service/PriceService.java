package io.reactivesw.order.cart.domain.service;

import io.reactivesw.catalog.productdiscount.model.DiscountedPrice;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.domain.entity.value.PriceValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by umasuo on 16/12/12.
 */
@Service
public class PriceService {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(PriceService.class);

  /**
   * get price value from price entity.
   *
   * @param price PriceValue
   * @return Money Entity
   */
  public MoneyEntity getPriceValue(PriceValue price) {
    DiscountedPrice discountedPrice = price.getDiscounted();
    MoneyEntity money;
    if (Objects.isNull(discountedPrice)) {
      money = price.getValue();
    } else {
      LOG.debug("Use DiscountedPrice, priceId: {}", price.getId());
      money = MoneyMapper.convertModelToEntity(discountedPrice.getValue());
    }
    return money;
  }
}
