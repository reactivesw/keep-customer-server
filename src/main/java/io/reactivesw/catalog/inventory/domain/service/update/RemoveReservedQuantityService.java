package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.RemoveReservedQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/22.
 */
@Service(value = InventoryEntryActionUtils.REMOVE_RESERVED_QUANTITY)
public class RemoveReservedQuantityService implements Update<InventoryEntryEntity> {
  /**
   * remove reserved quantity.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int removeQuantity = ((RemoveReservedQuantityAction) action).getRemoveReservedQuantity();
    int srcQuantity = entity.getQuantityOnStock();
    int srcReservedQuantity = entity.getReservedQuantity();
    if (removeQuantity > srcQuantity || removeQuantity > srcReservedQuantity) {
      throw new ParametersException(
          "remove quantity can not be greater than quantityOnStock or reservedQuantity");
    }
    entity.setQuantityOnStock(srcQuantity - removeQuantity);
    entity.setReservedQuantity(srcReservedQuantity - removeQuantity);
  }
}
