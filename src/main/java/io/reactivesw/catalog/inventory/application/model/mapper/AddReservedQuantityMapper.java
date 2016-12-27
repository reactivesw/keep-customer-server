package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.action.AddReservedQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/22.
 */
public class AddReservedQuantityMapper implements InventoryEntryUpdateMapper<InventoryEntryEntity> {
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int addReservedQuantity = ((AddReservedQuantityAction) action).getAddReservedQuantity();
    int srcQuantity = entity.getQuantityOnStock();
    int srcAvailableQuantity = entity.getAvailableQuantity();
    int srcReservedQuantity = entity.getReservedQuantity();

    if (addReservedQuantity > srcAvailableQuantity || addReservedQuantity > srcQuantity) {
      throw new ParametersException(
          "addReservedQuantity can not be greater than availabelQuantity and quantityOnStock");
    }

    entity.setAvailableQuantity(srcAvailableQuantity - addReservedQuantity);
    entity.setReservedQuantity(srcReservedQuantity + addReservedQuantity);
  }
}
