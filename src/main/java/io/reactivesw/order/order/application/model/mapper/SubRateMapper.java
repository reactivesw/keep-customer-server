package io.reactivesw.order.order.application.model.mapper;

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
}
