package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.reactivesw.order.order.domain.entity.value.TaxRateValue;

/**
 * Created by Davis on 17/2/7.
 */
public final class TaxRateMapper {
  /**
   * Instantiates a new Tax rate mapper.
   */
  private TaxRateMapper() {
  }

  /**
   * Model to entity tax rate value.
   *
   * @param model the model
   * @return the tax rate value
   */
  public static TaxRateValue modelToEntity(TaxRate model) {
    TaxRateValue entity = new TaxRateValue();

    if (model != null) {
      entity.setName(model.getName());
      entity.setAmount(model.getAmount());
      entity.setIncludedInPrice(model.getIncludedInPrice());
      entity.setCountry(model.getCountry());
      entity.setState(model.getState());
      entity.setSubRates(SubRateMapper.modelToEntity(model.getSubRates()));
    }

    return entity;
  }

  /**
   * Entity to model tax rate.
   *
   * @param entity the entity
   * @return the tax rate
   */
  public static TaxRate entityToModel(TaxRateValue entity) {
    // TODO: 17/2/7
    return null;
  }
}
