package io.reactivesw.common.model.mapper;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.Money;

/**
 * Created by umasuo on 16/12/8.
 */
public class MoneyMapper {

  public static MoneyEntity modelToEntity(Money model) {
    MoneyEntity entity = null;
    if (model != null) {
      entity = new MoneyEntity();
      entity.setCentAmount(model.getCentAmount());
      entity.setCurrencyCode(model.getCurrencyCode());
    }
    return entity;
  }

  public static Money entityToModel(MoneyEntity entity) {
    Money model = null;
    if (entity != null) {
      model = new Money();

      model.setCentAmount(entity.getCentAmount());
      model.setCurrencyCode(entity.getCurrencyCode());
    }
    return model;
  }

}
