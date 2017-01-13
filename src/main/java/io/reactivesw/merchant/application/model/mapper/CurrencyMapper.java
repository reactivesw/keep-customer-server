package io.reactivesw.merchant.application.model.mapper;

import io.reactivesw.merchant.application.model.Currency;
import io.reactivesw.merchant.domain.entity.CurrencyValue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 17/1/5.
 */
public class CurrencyMapper {

  /**
   * entity to model.
   *
   * @param entity CurrencyValue
   * @return Currency currency
   */
  public static Currency entityToModel(CurrencyValue entity) {
    Currency model = null;
    if (entity != null) {
      model = new Currency();
      model.setName(entity.getName());
      model.setCurrencyCode(entity.getCurrencyCode());
      model.setConversionFactor(entity.getConversionFactor());
    }
    return model;
  }

  /**
   * Entity to model list.
   *
   * @param entities the entities
   * @return the list
   */
  public static List<Currency> entityToModel(Set<CurrencyValue> entities) {
    return entities.parallelStream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }

  /**
   * Model to entity currency value.
   *
   * @param currency the currency
   * @return the currency value
   */
  public static CurrencyValue modelToEntity(Currency currency) {
    CurrencyValue entity = new CurrencyValue();

    entity.setName(currency.getName());
    entity.setCurrencyCode(currency.getCurrencyCode());
    entity.setConversionFactor(currency.getConversionFactor());

    return entity;
  }
}
