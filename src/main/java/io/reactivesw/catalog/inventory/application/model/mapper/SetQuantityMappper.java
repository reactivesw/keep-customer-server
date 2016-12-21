package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.action.SetQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/21.
 */
public class SetQuantityMappper implements InventoryEntryUpdateMapper<InventoryEntryEntity> {
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int quantity = ((SetQuantityAction) action).getQuantity();
    if (quantity < entity.getReservedQuantity()) {
      throw new ParametersException("quantityOnStock should large than reservedQuantity");
    }
    entity.setQuantityOnStock(quantity);
    entity.setAvailableQuantity(quantity - entity.getReservedQuantity());
  }
}
