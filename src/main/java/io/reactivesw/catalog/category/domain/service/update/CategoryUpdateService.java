package io.reactivesw.catalog.category.domain.service.update;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/29.
 */
@Service
public class CategoryUpdateService implements Update<CategoryEntity>{
  /**
   * application context.
   */
  @Autowired
  private transient ApplicationContext context;

  /**
   * update handle.
   * @param entity E entity
   * @param action UpdateAction
   */
  @Override
  public void handle(CategoryEntity entity, UpdateAction action) {
    handle(entity, action, context);
  }
}
