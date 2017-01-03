package io.reactivesw.catalog.taxcategory.domain.service.update;

import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service
public class TaxCategoryUpdateService implements Update<TaxCategoryEntity> {
  /**
   * application context.
   */
  @Autowired
  private transient ApplicationContext context;

  /**
   * default update handle.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(TaxCategoryEntity entity, UpdateAction action) {
    handle(entity, action, context);
  }
}
