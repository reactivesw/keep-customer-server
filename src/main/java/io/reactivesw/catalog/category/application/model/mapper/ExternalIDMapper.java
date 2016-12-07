package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.action.SetExternalID;
import io.reactivesw.catalog.category.domain.entities.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/7.
 */
public class ExternalIDMapper implements CategoryUpdateMapper<CategoryEntity> {

  @Override
  public void setAction(CategoryEntity entity, UpdateAction action) {
    SetExternalID setExternalID = (SetExternalID) action;
    entity.setExternalId(setExternalID.getExternalId());
  }
}
