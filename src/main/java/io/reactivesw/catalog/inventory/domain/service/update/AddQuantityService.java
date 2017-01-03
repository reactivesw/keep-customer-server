package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.AddQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service(value = InventoryEntryActionUtils.ADD_QUANTITY)
public class AddQuantityService implements Update<InventoryEntryEntity> {

  /**
   * add quantity.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int addQuantity = ((AddQuantityAction) action).getQuantity();
    entity.setQuantityOnStock(entity.getQuantityOnStock() + addQuantity);
    entity.setAvailableQuantity(entity.getAvailableQuantity() + addQuantity);
  }
}
