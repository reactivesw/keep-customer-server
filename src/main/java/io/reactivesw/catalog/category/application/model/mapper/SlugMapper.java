package io.reactivesw.catalog.category.application.model.mapper;

import io.reactivesw.catalog.category.application.model.action.SetSlug;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

/**
 * Created by Davis on 16/12/7.
 */
public class SlugMapper implements CategoryUpdateMapper<CategoryEntity> {

  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetSlug setSlug = (SetSlug) action;
    entity.setSlug(setSlug.getSlug());
  }
}
