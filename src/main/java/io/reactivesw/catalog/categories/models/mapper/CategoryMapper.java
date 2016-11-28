package io.reactivesw.catalog.categories.models.mapper;

import io.reactivesw.catalog.categories.entities.CategoryEntity;
import io.reactivesw.catalog.categories.models.Category;
import org.modelmapper.ModelMapper;

/**
 * Created by Davis on 16/11/28.
 */
public final class CategoryMapper {
  /**
   * model mapper.
   */
  private static ModelMapper mapper = new ModelMapper();

  /**
   * Map entity to category category.
   *
   * @param entity the entity
   * @return the category
   */
  public static Category entityToCategory(CategoryEntity entity) {
    return mapper.map(entity, Category.class);
  }
}
