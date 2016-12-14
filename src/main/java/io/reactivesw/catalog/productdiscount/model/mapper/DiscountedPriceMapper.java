package io.reactivesw.catalog.productdiscount.model.mapper;

import io.reactivesw.catalog.productdiscount.entity.ProductDiscountEntity;
import io.reactivesw.catalog.productdiscount.model.DiscountedPrice;
import io.reactivesw.common.model.mapper.MoneyMapper;

/**
 * Created by Davis on 16/12/14.
 */
public class DiscountedPriceMapper {
  public static DiscountedPrice entityToModel(ProductDiscountEntity entity) {
    DiscountedPrice model = new DiscountedPrice();

    // TODO: 16/12/14 need calculate

    return model;
  }
}
