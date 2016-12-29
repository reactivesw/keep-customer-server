package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.application.model.action.SetExternalID;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_EXTERNAL_ID)
public class SetExternalIdService implements Update<CategoryEntity> {

  /**
   * set external id.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetExternalID setExternalID = (SetExternalID) action;
    entity.setExternalId(setExternalID.getExternalId());
  }
}
