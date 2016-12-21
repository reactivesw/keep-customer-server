package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.action.RemoveQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/21.
 */
public class RemoveQuantityMapper implements InventoryEntryUpdateMapper<InventoryEntryEntity> {
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int removeQuantity = ((RemoveQuantityAction) action).getQuantity();
    int quantityOnStock = entity.getQuantityOnStock();
    int availableQuantity = entity.getAvailableQuantity();
    int reservedQuantity = entity.getReservedQuantity();

    if (removeQuantity > quantityOnStock || removeQuantity > availableQuantity) {
      throw new ParametersException(
          "can not remove more than quantityOnStock or availableQuantity");
    }

    entity.setQuantityOnStock(quantityOnStock - removeQuantity);
    entity.setAvailableQuantity(availableQuantity - removeQuantity);
  }
}
