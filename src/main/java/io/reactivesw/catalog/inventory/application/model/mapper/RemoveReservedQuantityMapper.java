package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.action.RemoveQuantityAction;
import io.reactivesw.catalog.inventory.application.model.action.RemoveReservedQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/22.
 */
public class RemoveReservedQuantityMapper implements
    InventoryEntryUpdateMapper<InventoryEntryEntity> {
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int removeQuantity = ((RemoveReservedQuantityAction) action).getRemoveReservedQuantity();
    int srcQuantity = entity.getQuantityOnStock();
    int srcReservedQuantity = entity.getReservedQuantity();
    if (removeQuantity > srcQuantity || removeQuantity > srcReservedQuantity) {
      throw new ParametersException("");
    }
    entity.setQuantityOnStock(srcQuantity - removeQuantity);
    entity.setReservedQuantity(srcReservedQuantity - removeQuantity);
  }
}
