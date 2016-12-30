package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/30.
 */
@Service
public class ProductTypeUpdateService implements Update<ProductTypeEntity>{

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
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    handle(entity, action, context);
  }
}
