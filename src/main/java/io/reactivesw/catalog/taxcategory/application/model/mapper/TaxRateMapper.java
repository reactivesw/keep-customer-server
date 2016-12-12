package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxRateEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/10.
 */
public final class TaxRateMapper {

  /**
   * convert List of TaxRateDraft to Set of TaxRateEntity.
   *
   * @param drafts the List of TaxRateDraft
   * @return the Set of TaxRateEntity
   */
  public static Set<TaxRateEntity> modelToEntity(List<TaxRateDraft> drafts) {
    Set<TaxRateEntity> result = new HashSet<>();
    if (drafts != null && !drafts.isEmpty()) {
      result = drafts.stream().map(
          draft -> {
            return modelToEntity(draft);
          }
      ).collect(Collectors.toSet());
    }
    return result;
  }

  /**
   * convert TaxRateDraft to TaxRateEntity.
   *
   * @param draft the TaxRateDraft
   * @return the TaxRateEntity
   */
  public static TaxRateEntity modelToEntity(TaxRateDraft draft) {
    TaxRateEntity entity = new TaxRateEntity();

    entity.setName(draft.getName());
    entity.setCountry(draft.getCountry());
    entity.setState(draft.getState());
    entity.setIncludedInPrice(draft.getIncludedInPrice());
    entity.setAmount(new BigDecimal(draft.getAmount()));
    entity.setSubRates(SubRateMapper.modelToEntity(draft.getSubRates()));

    return entity;
  }

  /**
   * convert Set of TaxRateEntity to List of TaxRate.
   *
   * @param entities the et of TaxRateEntity
   * @return the List of TaxRate
   */
  public static List<TaxRate> entityToModel(Set<TaxRateEntity> entities) {
    List<TaxRate> models = new ArrayList<>();

    if (entities != null && !entities.isEmpty()) {
      models = entities.stream().map(
          entity -> {
            return entityToModel(entity);
          }
      ).collect(Collectors.toList());
    }
    return models;
  }

  /**
   * convert TaxRateEntity to TaxRate.
   *
   * @param entity TaxRateEntity
   * @return the TaxRate
   */
  public static TaxRate entityToModel(TaxRateEntity entity) {
    TaxRate model = new TaxRate();

    model.setId(entity.getId());
    model.setName(entity.getName());
    model.setCountry(entity.getCountry());
    model.setState(entity.getState());
    model.setAmount(entity.getAmount().floatValue());
    model.setIncludedInPrice(entity.getIncludedInPrice());
    model.setSubRates(SubRateMapper.entityToModel(entity.getSubRates()));

    return model;
  }

  /**
   * replace TaxRateDraft to TaxRateEntity.
   *
   * @param draft  the TaxRateDraft
   * @param entity the TaxRateEntity
   * @return the TaxRateEntity
   */
  public static TaxRateEntity modelToEntity(TaxRateDraft draft, TaxRateEntity entity) {
    TaxRateEntity result = modelToEntity(draft);
    result.setId(entity.getId());
    return result;
  }
}
