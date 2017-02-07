package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.SubRate;
import io.reactivesw.order.order.domain.entity.value.SubRateValue;

import java.util.List;
import java.util.Set;

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
    // TODO: 17/2/7  
    return null;
  }
}
