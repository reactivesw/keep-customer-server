package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.application.model.action.SetOrderHint;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_ORDER_HINT)
public class SetOrderHintService implements Update<CategoryEntity> {
  /**
   * set order hint.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetOrderHint setOrderHint = (SetOrderHint) action;
    entity.setOrderHint(setOrderHint.getOrderHint());
  }
}
