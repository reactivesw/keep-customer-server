package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.product.application.model.CategoryOrderHint;
import io.reactivesw.catalog.product.domain.entity.CategoryOrderHintEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/20.
 */
public final class CategoryOrderHintsMapper {
  /**
   * Model to entity list.
   *
   * @param models the models
   * @return the list
   */
  public static List<CategoryOrderHintEntity> modelToEntity(List<CategoryOrderHint> models) {
    return models.stream().map(
        model -> {
          return new CategoryOrderHintEntity(model.getKey(), model.getOrder());
        }
    ).collect(Collectors.toList());
  }

  /**
   * Entity to model list.
   *
   * @param entities the entities
   * @return the list
   */
  public static List<CategoryOrderHint> entityToModel(List<CategoryOrderHintEntity> entities) {
    return entities.stream().map(
        entity -> {
          return new CategoryOrderHint(entity.getCategoryId(), entity.getOrderHint());
        }
    ).collect(Collectors.toList());
  }
}
