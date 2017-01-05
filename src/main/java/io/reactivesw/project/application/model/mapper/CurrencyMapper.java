package io.reactivesw.project.application.model.mapper;

import io.reactivesw.project.application.model.Currency;
import io.reactivesw.project.domain.entity.CurrencyValue;

/**
 * Created by umasuo on 17/1/5.
 */
public class CurrencyMapper {

  /**
   * entity to model.
   *
   * @param entity CurrencyValue
   * @return Currency
   */
  public static Currency entityToModel(CurrencyValue entity) {
    Currency model = null;
    if (entity != null) {
      model = new Currency();
      model.setName(entity.getName());
      model.setCurrencyCode(entity.getCurrencyCode());
      model.setId(entity.getId());
    }
    return model;
  }
}
