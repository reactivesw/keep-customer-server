package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.action.SetOrderHint;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/7.
 */
public class OrderHintMapper implements CategoryUpdateMapper<CategoryEntity> {

  @Override
  public void setAction(CategoryEntity entity, UpdateAction action) {
    SetOrderHint setOrderHint = (SetOrderHint) action;
    entity.setOrderHint(setOrderHint.getOrderHint());
  }
}
