package io.reactivesw.catalog.categories.models.mapper;

import io.reactivesw.catalog.categories.entities.CategoryEntity;
import io.reactivesw.catalog.categories.models.Category;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.models.Reference;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

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
    Category category = mapper.map(entity, Category.class);
    //add reference type.
    category.setAncestors(entityToReferenceList(entity.getAncestors()));
    String parentId = entity.getParent();
    //add reference type to parent.
    if (parentId != null) {
      category.setParent(new Reference(ReferenceTypes.CATEGORY.getType(), parentId));
    }
    return category;
  }

  /**
   * transfer List of ancestor ids to List of Reference about category.
   *
   * @param ancestors list of ancestor ids
   * @return list of Reference
   */
  private static List<Reference> entityToReferenceList(List<String> ancestors) {
    List<Reference> result = new ArrayList<>();
    if (ancestors != null) {
      String typeId = ReferenceTypes.CATEGORY.getType();
      for (String ancestorId : ancestors) {
        result.add(new Reference(typeId, ancestorId));
      }
    }
    return result;
  }
}
