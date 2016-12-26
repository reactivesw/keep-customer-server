package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.application.model.TaxedItemPrice;
import io.reactivesw.order.cart.domain.entity.value.TaxedItemPriceValue;

/**
 * Created by umasuo on 16/12/26.
 */
public class TaxedItemPriceMapper {

  public static TaxedItemPrice entityToModel(TaxedItemPriceValue entity) {
    TaxedItemPrice value = null;
    if (entity != null) {
      value = new TaxedItemPrice();
      value.setTotalGross(MoneyMapper.entityToModel(entity.getTotalGross()));
      value.setTotalNet(MoneyMapper.entityToModel(entity.getTotalNet()));
    }
    return value;
  }

  public static TaxedItemPriceValue entityToModel(TaxedItemPrice value) {
    TaxedItemPriceValue entity = null;
    if (value != null) {
      entity = new TaxedItemPriceValue();
      entity.setTotalGross(MoneyMapper.modelToEntity(value.getTotalGross()));
      entity.setTotalNet(MoneyMapper.modelToEntity(value.getTotalNet()));
    }
    return entity;
  }
}
