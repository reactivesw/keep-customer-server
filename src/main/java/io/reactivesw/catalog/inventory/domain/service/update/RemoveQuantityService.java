package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.RemoveQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/21.
 */
@Service(value = InventoryEntryActionUtils.REMOVE_QUANTITY)
public class RemoveQuantityService implements Update<InventoryEntryEntity> {
  /**
   * remove quantity.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int removeQuantity = ((RemoveQuantityAction) action).getQuantity();
    int quantityOnStock = entity.getQuantityOnStock();
    int availableQuantity = entity.getAvailableQuantity();

    if (removeQuantity > quantityOnStock || removeQuantity > availableQuantity) {
      throw new ParametersException(
          "can not remove more than quantityOnStock or availableQuantity");
    }

    entity.setQuantityOnStock(quantityOnStock - removeQuantity);
    entity.setAvailableQuantity(availableQuantity - removeQuantity);
  }
}
