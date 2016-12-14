package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

/**
 * Created by Davis on 16/12/7.
 */
public class NameMapper implements CategoryUpdateMapper<CategoryEntity> {
  @Override
  public void setAction(CategoryEntity entity, UpdateAction action) {
    SetLocalizedName setLocalizedName = (SetLocalizedName) action;
    entity.setName(LocalizedStringMapper.modelToEntityDefaultNew(setLocalizedName.getName()));
  }
}
