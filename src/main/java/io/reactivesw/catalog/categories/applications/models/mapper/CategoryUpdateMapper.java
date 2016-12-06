package io.reactivesw.catalog.categories.applications.models.mapper;

import io.reactivesw.catalog.categories.applications.models.actions.ChangeName;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeOrderHint;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeParent;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeSlug;
import io.reactivesw.catalog.categories.applications.models.actions.SetDescription;
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

    if (updateAction instanceof ChangeName) {
      entity.setName(LocalizedStringMapper.convertToLocalizedStringEntity(((ChangeName)
          updateAction).getName()));
    } else if (updateAction instanceof ChangeSlug
        && ((ChangeSlug) updateAction).getSlug() != null) {
      entity.setSlug(LocalizedStringMapper.convertToLocalizedStringEntity(((ChangeSlug)
          updateAction).getSlug()));
    } else if (updateAction instanceof SetDescription) {
      entity.setDescription(LocalizedStringMapper.convertToLocalizedStringEntity((
          (SetDescription) updateAction).getDescription()));
    } else if (updateAction instanceof ChangeParent) {
      entity.setParent(((ChangeParent) updateAction).getParent().getId());
    } else if (updateAction instanceof ChangeOrderHint) {
      entity.setOrderHint(((ChangeOrderHint) updateAction).getOrderHint());
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
