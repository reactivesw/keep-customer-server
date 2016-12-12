package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetName;

/**
 * Created by Davis on 16/12/8.
 */
public class SetNameMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {

  @Override
  public void setAction(ProductTypeEntity entity, UpdateAction action) {
    SetName setName = (SetName)action;
    entity.setKey(setName.getName());
  }
}
