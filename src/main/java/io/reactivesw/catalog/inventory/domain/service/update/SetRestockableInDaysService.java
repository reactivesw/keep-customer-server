package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.SetRestockableInDays;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/21.
 */
@Service(value = InventoryEntryActionUtils.SET_RESTOCKABLE_IN_DAYS)
public class SetRestockableInDaysService implements Update<InventoryEntryEntity> {

  /**
   * set restockable in days.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    Integer restockableInDays = ((SetRestockableInDays) action).getRestockableInDays();
    entity.setRestockableInDays(restockableInDays);
  }
}
