package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service
public class InventoryEntryUpdateService implements Update<InventoryEntryEntity> {
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
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    handle(entity, action, context);
  }
}
