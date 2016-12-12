package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.SubRate;
import io.reactivesw.catalog.taxcategory.domain.entity.SubRateEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/10.
 */
public final class SubRateMapper {

  /**
   * convert List of SubRate to Set of SubRateEntity.
   *
   * @param subRates the List of SubRate
   * @return the Set of SubRateEntity
   */
  public static Set<SubRateEntity> modelToEntity(List<SubRate> subRates) {
    Set<SubRateEntity> entities = new HashSet<>();
    if (subRates != null && !subRates.isEmpty()) {
      entities = subRates.stream().map(
          subRate -> {
            return modelToEntity(subRate);
          }
      ).collect(Collectors.toSet());
    }
    return entities;
  }

  /**
   * convert SubRate to SubRateEntity.
   *
   * @param subRate the SubRate
   * @return the SubRateEntity
   */
  public static SubRateEntity modelToEntity(SubRate subRate) {
    SubRateEntity entity = new SubRateEntity();

    entity.setName(subRate.getName());
    entity.setAmount(new BigDecimal(subRate.getAmount()));

    return entity;
  }

  /**
   * convert Set of SubRateEntity to List of SubRate.
   *
   * @param entities the Set of SubRateEntity
   * @return the List of SubRate
   */
  public static List<SubRate> entityToModel(Set<SubRateEntity> entities) {
    List<SubRate> models = new ArrayList<>();
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
   * convert SubRateEntity to SubRate.
   *
   * @param entity the SubRateEntity
   * @return the SubRate
   */
  public static SubRate entityToModel(SubRateEntity entity) {
    SubRate model = new SubRate();

    model.setName(entity.getName());
    model.setAmount(entity.getAmount().floatValue());

    return model;
  }
}
