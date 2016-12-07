package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.action.SetSlug;
import io.reactivesw.catalog.category.domain.entities.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

/**
 * Created by Davis on 16/12/7.
 */
public class SlugMapper implements CategoryUpdateMapper<CategoryEntity> {

  @Override
  public void setAction(CategoryEntity entity, UpdateAction action) {
    SetSlug setSlug = (SetSlug) action;
    entity.setSlug(LocalizedStringMapper.modelToEntityDefaultNew(setSlug.getSlug()));
  }
}
