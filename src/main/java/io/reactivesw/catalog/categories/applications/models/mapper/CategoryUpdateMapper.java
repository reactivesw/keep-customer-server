package io.reactivesw.catalog.categories.applications.models.mapper;

import io.reactivesw.common.models.updateactions.SetLocalizedDescription;
import io.reactivesw.common.models.updateactions.SetLocalizedName;
import io.reactivesw.catalog.categories.applications.models.actions.SetOrderHint;
import io.reactivesw.catalog.categories.applications.models.actions.SetParent;
import io.reactivesw.catalog.categories.applications.models.actions.SetSlug;
import io.reactivesw.catalog.categories.applications.models.actions.SetExternalID;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaDescription;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaKeywords;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaTitle;
import io.reactivesw.catalog.categories.domains.entities.CategoryEntity;
import io.reactivesw.common.models.UpdateAction;
import io.reactivesw.common.models.mapper.LocalizedStringMapper;

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
