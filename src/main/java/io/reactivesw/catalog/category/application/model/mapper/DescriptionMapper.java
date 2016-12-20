package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

/**
 * Created by Davis on 16/12/7.
 */
public class DescriptionMapper implements CategoryUpdateMapper<CategoryEntity> {
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetLocalizedDescription setLocalizedDescription = (SetLocalizedDescription) action;
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNew(setLocalizedDescription
        .getDescription()));
  }
}
