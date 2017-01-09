package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.application.model.action.SetParent;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.domain.service.CategoryService;
import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service(value = CategoryActionUtils.SET_PARENT)
public class SetParentService implements Update<CategoryEntity> {

  /**
   * category service.
   */
  @Autowired
  private transient CategoryService categoryService;

  /**
   * set parent.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    SetParent setParent = (SetParent) action;
    categoryService.setParentAndAncestors(entity, setParent.getParent().getId());
    // TODO: 16/12/28 should change ancestors and subCategory's ancestors
  }
}
