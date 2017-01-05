package io.reactivesw.project.application.model.mapper;

import com.google.common.collect.Sets;

import io.reactivesw.project.application.model.Currency;
import io.reactivesw.project.application.model.International;
import io.reactivesw.project.domain.entity.CurrencyValue;
import io.reactivesw.project.domain.entity.InternationalEntity;

/**
 * Created by Davis on 17/1/5.
 */
public final class InternationalMapper {
  /**
   * Instantiates a new International mapper.
   */
  private InternationalMapper() {}

  /**
   * Model to entity international entity.
   *
   * @param model the model
   * @return the international entity
   */
  public static InternationalEntity modelToEntity(Currency model) {
    InternationalEntity entity = new InternationalEntity();

    CurrencyValue defaultCurrency = CurrencyMapper.modelToEntity(model);

    entity.setDefaultCurrency(defaultCurrency);
    entity.setSupportedCurrency(Sets.newHashSet(defaultCurrency));

    return entity;
  }

  /**
   * Entity to model international.
   *
   * @param entity the entity
   * @return the international
   */
  public static International entityToModel(InternationalEntity entity) {
    International model = new International();

    model.setDefaultCurrency(CurrencyMapper.entityToModel(entity.getDefaultCurrency()));
    model.setSupportCurrencies(CurrencyMapper.entityToModel(entity.getSupportedCurrency()));

    return model;
  }
}
