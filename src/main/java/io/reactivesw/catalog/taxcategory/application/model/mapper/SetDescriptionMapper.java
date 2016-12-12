package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetDescription;

/**
 * Created by Davis on 16/12/11.
 */
public class SetDescriptionMapper implements TaxCategoryUpdateMapper<TaxCategoryEntity> {
  @Override
  public void setAction(TaxCategoryEntity entity, UpdateAction action) {
    SetDescription setDescription = (SetDescription) action;
    entity.setDescription(setDescription.getDescription());
  }
}
