package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.SetQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/21.
 */
@Service(value = InventoryEntryActionUtils.SET_QUANTITY)
public class SetQuantityService implements Update<InventoryEntryEntity> {
  /**
   * set quantity.
   * @param entity E
   * @param action UpdateAction
   */
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
