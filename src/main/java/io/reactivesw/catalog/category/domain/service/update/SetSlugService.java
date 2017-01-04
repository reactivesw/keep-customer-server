package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.application.model.action.SetSlug;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_SLUG)
public class SetSlugService implements Update<CategoryEntity> {

  /**
   * update handle.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetSlug setSlug = (SetSlug) action;
    entity.setSlug(setSlug.getSlug());
  }
}
