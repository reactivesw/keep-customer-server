package io.reactivesw.order.order.application.model.mapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import io.reactivesw.catalog.taxcategory.application.model.SubRate;
import io.reactivesw.order.order.domain.entity.value.SubRateValue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/2/7.
 */
public final class SubRateMapper {
  /**
   * Instantiates a new Sub rate mapper.
   */
  private SubRateMapper() {
  }

  /**
   * Model to entity set.
   *
   * @param models the models
   * @return the set
   */
  public static Set<SubRateValue> modelToEntity(List<SubRate> models) {
    Set entities = Sets.newHashSet();
    if (models != null) {
      entities = models.parallelStream().map(
          model -> {
            return modelToEntity(model);
          }
      ).collect(Collectors.toSet());
    }

    return entities;
  }

  /**
   * Model to entity sub rate value.
   *
   * @param model the model
   * @return the sub rate value
   */
  public static SubRateValue modelToEntity(SubRate model) {
    SubRateValue entity = new SubRateValue();

    entity.setAmount(model.getAmount());
    entity.setName(model.getName());

    return entity;
  }

  /**
   * Entity to model list.
   *
   * @param entities the models
   * @return the list
   */
  public static List<SubRate> entityToModel(Set<SubRateValue> entities) {
    List<SubRate> models = Lists.newArrayList();

    if (entities != null) {
      models = entities.parallelStream().map(
          entity -> {
            return entityToModel(entity);
          }
      ).collect(Collectors.toList());
    }

    return models;
  }

  /**
   * Entity to model sub rate.
   *
   * @param entity the entity
   * @return the sub rate
   */
  public static SubRate entityToModel(SubRateValue entity) {
    SubRate model = new SubRate();

    if (entity != null) {
      model.setName(entity.getName());
      model.setAmount(entity.getAmount());
    }

    return model;
  }
}
