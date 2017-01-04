package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.application.model.action.SetMetaTitle;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_META_TITLE)
public class SetMetaTitleService implements Update<CategoryEntity> {

  /**
   * set meta title.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetMetaTitle setMetaTitle = (SetMetaTitle) action;
    entity.setMetaTitle(LocalizedStringMapper.modelToEntityDefaultNew(setMetaTitle.getMetaTitle()));
  }
}
