package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetName;

/**
 * Created by Davis on 16/12/11.
 */
public class SetNameMapper implements TaxCategoryUpdateMapper<TaxCategoryEntity> {

  @Override
  public void handle(TaxCategoryEntity entity, UpdateAction action) {
    SetName setName = (SetName) action;
    entity.setName(setName.getName());
  }
}
