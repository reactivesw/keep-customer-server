package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.Category;
import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/11/28.
 */
public final class CategoryMapper {

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
    Category category = new Category();
    //add reference type.
    category.setId(entity.getId());
    category.setAncestors(convertToReferenceList(entity.getAncestors()));
    String parentId = entity.getParent();
    //add reference type to parent.
    if (StringUtils.isNotBlank(parentId)) {
      category.setParent(new Reference(ReferenceTypes.CATEGORY.getType(), parentId));
    }
    category.setName(LocalizedStringMapper.entityToModelDefaultNull(entity.getName()));
    category.setSlug(entity.getSlug());
    category.setDescription(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getDescription()));
    category.setOrderHint(entity.getOrderHint());
    category.setExternalId(entity.getExternalId());
    category.setMetaTitle(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaTitle()));
    category.setMetaKeywords(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaKeyWords()));
    category.setMetaDescription(LocalizedStringMapper.entityToModelDefaultNull(entity
        .getMetaDescription()));
    category.setVersion(entity.getVersion());
    category.setCreatedAt(entity.getCreatedAt());
    category.setLastModifiedAt(entity.getLastModifiedAt());
    category.setCustom(entity.getCustom());
    return category;
  }


  /**
   * mapper Draft to category entity.
   *
   * @param model the draft
   * @return the category entity
   */
  public static CategoryEntity modelToEntity(CategoryDraft model,
                                             String parentId, List<String> ancestors) {
    CategoryEntity entity = new CategoryEntity();

    entity.setName(LocalizedStringMapper.modelToEntityDefaultNull(model.getName
        ()));
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNull(model
        .getDescription()));
    entity.setSlug(model.getSlug());
    entity.setOrderHint(model.getOrderHint());
    entity.setExternalId(model.getExternalId());
    entity.setMetaTitle(LocalizedStringMapper.modelToEntityDefaultNull(model
        .getMetaTitle()));
    entity.setMetaDescription(LocalizedStringMapper.modelToEntityDefaultNull(model
        .getMetaDescription()));
    entity.setMetaKeyWords(LocalizedStringMapper.modelToEntityDefaultNull(model
        .getMetaKeywords()));
    //TODO set custom fields
    if (model.getCustom() == null) {
      entity.setCustom(null);
    }
    entity.setParent(parentId);
    entity.setAncestors(ancestors);
    return entity;
  }


  /**
   * convert List of CategoryEntity to List of Category.
   *
   * @param entities the List of CategoryEntity
   * @return the List of Category
   */
  public static List<Category> entityToModel(List<CategoryEntity> entities) {
    return entities.stream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
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
