package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.catalog.category.application.model.action.SetOrderHint;
import io.reactivesw.catalog.category.application.model.action.SetParent;
import io.reactivesw.catalog.category.application.model.action.SetSlug;
import io.reactivesw.catalog.category.application.model.action.SetExternalID;
import io.reactivesw.catalog.category.application.model.action.SetMetaDescription;
import io.reactivesw.catalog.category.application.model.action.SetMetaKeywords;
import io.reactivesw.catalog.category.application.model.action.SetMetaTitle;
import io.reactivesw.catalog.category.domain.entities.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

/**
 * Created by Davis on 16/12/6.
 */
public final class CategoryUpdateMapper {

  /**
   * Update category entity.
   *
   * @param updateAction the update action
   * @param entity       the entity
   * @return the category entity
   */
  public static CategoryEntity updateCategoryEntity(UpdateAction updateAction, CategoryEntity
      entity) {

    if (updateAction instanceof SetLocalizedName) {
      entity.setName(LocalizedStringMapper.convertToLocalizedStringEntity(((SetLocalizedName)
          updateAction).getName()));
    } else if (updateAction instanceof SetSlug
        && ((SetSlug) updateAction).getSlug() != null) {
      entity.setSlug(LocalizedStringMapper.convertToLocalizedStringEntity(((SetSlug)
          updateAction).getSlug()));
    } else if (updateAction instanceof SetLocalizedDescription) {
      entity.setDescription(LocalizedStringMapper.convertToLocalizedStringEntity((
          (SetLocalizedDescription) updateAction).getDescription()));
    } else if (updateAction instanceof SetParent) {
      entity.setParent(((SetParent) updateAction).getParent().getId());
    } else if (updateAction instanceof SetOrderHint) {
      entity.setOrderHint(((SetOrderHint) updateAction).getOrderHint());
    } else if (updateAction instanceof SetExternalID) {
      entity.setExternalId(((SetExternalID) updateAction).getExternalId());
    } else if (updateAction instanceof SetMetaTitle) {
      entity.setMetaTitle(LocalizedStringMapper.convertToLocalizedStringEntity(((SetMetaTitle)
          updateAction).getMetaTitle()));
    } else if (updateAction instanceof SetMetaDescription) {
      entity.setMetaDescription(LocalizedStringMapper.convertToLocalizedStringEntity((
          (SetMetaDescription) updateAction).getMetaDescription()));
    } else if (updateAction instanceof SetMetaKeywords) {
      entity.setMetaKeyWords(LocalizedStringMapper.convertToLocalizedStringEntity((
          (SetMetaKeywords) updateAction).getMetaKeywords()));
    }
    // TODO: SetCustomType and SetCustomField
    return entity;
  }
}
