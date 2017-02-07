package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cart.application.model.TaxedPrice;
import io.reactivesw.order.order.domain.entity.value.TaxedPriceValue;

/**
 * Created by Davis on 17/2/6.
 */
public final class TaxedPriceMapper {
  /**
   * Instantiates a new Taxed price mapper.
   */
  public TaxedPriceMapper() {
  }

  /**
   * Model to entity taxed price value.
   *
   * @param model the model
   * @return the taxed price value
   */
  public static TaxedPriceValue modelToEntity(TaxedPrice model) {
    TaxedPriceValue entity = new TaxedPriceValue();

    if (model != null) {
      entity.setTotalNet(MoneyMapper.modelToEntity(model.getTotalNet()));
      entity.setTotalGross(MoneyMapper.modelToEntity(model.getTotalGross()));
      // TODO: 17/2/6
      entity.setTaxPortions(null);
    }

    return entity;
  }

  /**
   * Entity to model taxed price.
   *
   * @param taxedPrice the taxed price
   * @return the taxed price
   */
  public static TaxedPrice entityToModel(TaxedPriceValue taxedPrice) {
    TaxedPrice model = new TaxedPrice();

    // TODO: 17/2/6
    
    return model;
  }
}
