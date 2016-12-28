package io.reactivesw.catalog.category.infrastructure.util;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;

import java.util.List;

/**
 * Created by Davis on 16/12/28.
 */
public final class CategoryUtils {
  /**
   * Instantiates a new Category util.
   */
  private CategoryUtils() {
  }

  /**
   * get all names from list of CategoryEntity.
   *
   * @param categories list of CategoryEntity
   * @return list of LocalizedStringEntity
   */
  public static List<LocalizedStringEntity> getAllCategoryNames(List<CategoryEntity> categories) {
    List<LocalizedStringEntity> categoryNames = Lists.newArrayList();
    if (categories != null) {
      categories.stream()
          .map(categoryEntity -> categoryEntity.getName())
          .forEach(categoryNames::addAll);
    }
    return categoryNames;
  }
}
