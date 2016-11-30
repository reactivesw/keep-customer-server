package io.reactivesw.catalog.categories.applications.models.mapper;

import io.reactivesw.catalog.categories.applications.models.CategoryDraft;
import io.reactivesw.catalog.categories.domains.entities.CategoryEntity;
import io.reactivesw.catalog.categories.applications.models.Category;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.models.Reference;
import io.reactivesw.common.models.mapper.LocalizedStringMapper;
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
    //TODO extract to other method
    category.setName(LocalizedStringMapper.convertToLocalizedStringDefaultNull(entity.getName()));
    category.setSlug(LocalizedStringMapper.convertToLocalizedStringDefaultNull(entity.getSlug()));
    category.setDescription(LocalizedStringMapper.convertToLocalizedStringDefaultNull(entity
        .getDescription()));
    category.setMetaTitle(LocalizedStringMapper.convertToLocalizedStringDefaultNull(entity
        .getMetaTitle()));
    category.setMetaKeywords(LocalizedStringMapper.convertToLocalizedStringDefaultNull(entity
        .getMetaKeyWords()));
    category.setMetaDescription(LocalizedStringMapper.convertToLocalizedStringDefaultNull(entity
        .getMetaDescription()));
    return category;
  }


  /**
   * mapper Draft to category entity.
   *
   * @param draft the draft
   * @return the category entity
   */
  //TODO
  public static CategoryEntity draftToCategoryEntity(CategoryDraft draft) {
    CategoryEntity entity = mapper.map(draft, CategoryEntity.class);
    return entity;
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
