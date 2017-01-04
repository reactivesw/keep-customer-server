package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.AddReservedQuantityAction;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/22.
 */
@Service(value = InventoryEntryActionUtils.ADD_RESERVED_QUANTITY)
public class AddReservedQuantityService implements Update<InventoryEntryEntity> {
  /**
   * add reserved quantity.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    int addReservedQuantity = ((AddReservedQuantityAction) action).getAddReservedQuantity();
    int srcQuantity = entity.getQuantityOnStock();
    int srcAvailableQuantity = entity.getAvailableQuantity();

    if (addReservedQuantity > srcAvailableQuantity || addReservedQuantity > srcQuantity) {
      throw new ParametersException(
          "addReservedQuantity can not be greater than availabelQuantity and quantityOnStock");
    }

    entity.setAvailableQuantity(srcAvailableQuantity - addReservedQuantity);
    entity.setReservedQuantity(entity.getReservedQuantity() + addReservedQuantity);
  }
}
