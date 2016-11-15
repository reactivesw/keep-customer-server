package io.reactivesw.customer.server.catalog.models.mapper;

import io.reactivesw.customer.server.catalog.entities.CategoryEntity;
import io.reactivesw.customer.server.catalog.models.Category;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper for CategoryEntity and Category.
 * Created by Davis on 16/11/14.
 */
public final class CategoryMapper {
  /**
   * model mapper.
   */
  private static ModelMapper modelMapper = new ModelMapper();

  /**
   * private controcutor.
   */
  private CategoryMapper() {
  }

  /**
   * Create model category.
   *
   * @param entity the entity
   * @return the category
   */
  public static Category createModel(CategoryEntity entity) {
    return modelMapper.map(entity, Category.class);
  }

  /**
   * Update entity category entity.
   *
   * @param category       the category
   * @param categoryEntity the category entity
   * @return the category entity
   */
  public static CategoryEntity updateEntity(Category category, CategoryEntity categoryEntity) {
    if (category.getName() != null) {
      categoryEntity.setName(category.getName());
    }
    if (category.getDescription() != null) {
      categoryEntity.setDescription(category.getDescription());
    }
    if (category.getParentId() != null) {
      categoryEntity.setParentId(category.getParentId());
    }
    return categoryEntity;
  }


  /**
   * Create entity category entity.
   *
   * @param model the model
   * @return the category entity
   */
  public static CategoryEntity createEntity(Category model) {
    return modelMapper.map(model, CategoryEntity.class);
  }

  /**
   * Create model list.
   *
   * @param categoryEntities the category entities
   * @return the list
   */
  public static List<Category> createModelList(List<CategoryEntity> categoryEntities) {
    List<Category> categories = new ArrayList<>();
    for (CategoryEntity category : categoryEntities) {
      categories.add(createModel(category));
    }
    return categories;
  }
}
