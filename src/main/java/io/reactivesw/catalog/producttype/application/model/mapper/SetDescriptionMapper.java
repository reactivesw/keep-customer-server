package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetDescription;

/**
 * Created by Davis on 16/12/8.
 */
public class SetDescriptionMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {

  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetDescription setDescription = (SetDescription) action;
    entity.setDescription(setDescription.getDescription());
  }
}
