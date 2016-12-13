package io.reactivesw.common.model.mapper;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.Money;

/**
 * Created by umasuo on 16/12/8.
 */
public class MoneyMapper {

  public static MoneyEntity convertModelToEntity(Money model) {
    MoneyEntity entity = new MoneyEntity();
    entity.setCentAmount(model.getCentAmount());
    entity.setCurrencyCode(model.getCurrencyCode());
    return entity;
  }

  public static Money convertEntityToModel(MoneyEntity entity) {
    Money model = new Money();
    model.setCentAmount(entity.getCentAmount());
    model.setCurrencyCode(entity.getCurrencyCode());
    return model;
  }

}
