package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.SetKey;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/8.
 */
public class SetKeyMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {

  @Override
  public void setAction(ProductTypeEntity entity, UpdateAction action) {
    SetKey setKey = (SetKey)action;
    entity.setKey(setKey.getKey());
  }
}
