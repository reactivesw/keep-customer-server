package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.application.model.TaxedItemPrice;
import io.reactivesw.order.order.domain.entity.value.TaxedItemPriceValue;

/**
 * Created by Davis on 17/2/7.
 */
public final class TaxedItemPriceMapper {
  /**
   * Instantiates a new Taxed item price mapper.
   */
  private TaxedItemPriceMapper() {
  }

  /**
   * Model to entity taxed item price value.
   *
   * @param model the model
   * @return the taxed item price value
   */
  public static TaxedItemPriceValue modelToEntity(TaxedItemPrice model) {
    TaxedItemPriceValue entity = new TaxedItemPriceValue();

    if (model != null) {
      entity.setTotalNet(MoneyMapper.modelToEntity(model.getTotalNet()));
      entity.setTotalGross(MoneyMapper.modelToEntity(model.getTotalGross()));
    }

    return entity;
  }
}
