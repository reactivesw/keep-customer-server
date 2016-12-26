package io.reactivesw.order.cart.application.model.mapper;


import io.reactivesw.order.cart.application.model.TaxRate;
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue;

/**
 * Created by Davis on 16/12/10.
 */
public final class TaxRateMapper {

  /**
   * convert TaxRateEntity to TaxRate.
   *
   * @param entity TaxRateEntity
   * @return the TaxRate
   */
  public static TaxRate entityToModel(TaxRateValue entity) {
    TaxRate model = null;
    if (entity != null) {
      model = new TaxRate();

      model.setId(entity.getId());
      model.setName(entity.getName());
      model.setCountry(entity.getCountry());
      model.setState(entity.getState());
      model.setAmount(entity.getAmount());
      model.setIncludedInPrice(entity.getIncludedInPrice());
      model.setSubRates(SubRateMapper.entityToModel(entity.getSubRates()));
    }
    return model;
  }


}
