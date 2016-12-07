package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.catalog.category.domain.entities.CategoryEntity;
import io.reactivesw.catalog.category.application.model.Category;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/11/28.
 */
public final class CategoryMapper {
  /**
   * model mapper.
   */
  private static ModelMapper mapper = new ModelMapper();

  /**
   * constructor.
   */
  private CategoryMapper() {
  }

  /**
   * Map entity to category category.
   *
   * @param entity the entity
   * @return the category
   */
  public static Category entityToModel(CategoryEntity entity) {
    Category category = mapper.map(entity, Category.class);
    //add reference type.
    category.setAncestors(convertToReferenceList(entity.getAncestors()));
    String parentId = entity.getParent();
    //add reference type to parent.
    if (StringUtils.isNotBlank(parentId)) {
      category.setParent(new Reference(ReferenceTypes.CATEGORY.getType(), parentId));
    }
    //TODO extract to other method
    category.setName(LocalizedStringMapper.entityToModelDefaultNull(entity.getName()));
    category.setSlug(LocalizedStringMapper.entityToModelDefaultNull(entity.getSlug()));
    category.setDescription(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getDescription()));
    category.setMetaTitle(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaTitle()));
    category.setMetaKeywords(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaKeyWords()));
    category.setMetaDescription(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaDescription()));
    return category;
  }


  /**
   * mapper Draft to category entity.
   *
   * @param draft the draft
   * @return the category entity
   */
  public static CategoryEntity modelToEntity(CategoryDraft draft) {
    CategoryEntity entity = mapper.map(draft, CategoryEntity.class);
    entity.setName(LocalizedStringMapper.modelToEntityDefaultNull(draft.getName
        ()));
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNull(draft
        .getDescription()));
    entity.setSlug(LocalizedStringMapper.modelToEntityDefaultNull(draft.getSlug
        ()));
    entity.setMetaTitle(LocalizedStringMapper.modelToEntityDefaultNull(draft
        .getMetaTitle()));
    entity.setMetaDescription(LocalizedStringMapper.modelToEntityDefaultNull(draft
        .getMetaDescription()));
    entity.setMetaKeyWords(LocalizedStringMapper.modelToEntityDefaultNull(draft
        .getMetaKeywords()));
    //TODO set custom fields
    if (draft.getCustom() == null) {
      entity.setCustom(null);
    }
    return entity;
  }

  /**
   * transfer List of ancestor ids to List of Reference about category.
   *
   * @param ancestors list of ancestor ids
   * @return list of Reference
   */
  private static List<Reference> convertToReferenceList(List<String> ancestors) {
    List<Reference> result = new ArrayList<>();
    if (ancestors != null) {
      String typeId = ReferenceTypes.CATEGORY.getType();
      result = ancestors.stream()
          .map(ancestor -> new Reference(typeId, ancestor))
          .collect(Collectors.toList());
    }
    return result;
  }
}
