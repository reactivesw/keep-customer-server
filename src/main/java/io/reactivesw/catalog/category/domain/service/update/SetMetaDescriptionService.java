package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.application.model.action.SetMetaDescription;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_META_DESCRIPTION)
public class SetMetaDescriptionService implements Update<CategoryEntity> {
  /**
   * set meta description.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetMetaDescription setMetaDescription = (SetMetaDescription) action;
    entity.setMetaDescription(LocalizedStringMapper.modelToEntityDefaultNew(setMetaDescription
        .getMetaDescription()));
  }
}
