package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.action.SetRestockableInDays;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/21.
 */
public class SetRestockableInDaysMapper implements
    InventoryEntryUpdateMapper<InventoryEntryEntity> {

  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    Integer restockableInDays = ((SetRestockableInDays) action).getRestockableInDays();
    entity.setRestockableInDays(restockableInDays);
  }
}
