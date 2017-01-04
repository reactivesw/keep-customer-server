package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_DESCRIPTION)
public class SetDescriptionService implements Update<CategoryEntity> {
  /**
   * set description.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetLocalizedDescription setLocalizedDescription = (SetLocalizedDescription) action;
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNew(setLocalizedDescription
        .getDescription()));
  }
}
