package io.reactivesw.catalog.inventory.domain.service.update;

import io.reactivesw.catalog.inventory.application.model.action.SetExpectedDelivery;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/12/21.
 */
@Service(value = InventoryEntryActionUtils.SET_EXPECTED_DELIVERY)
public class SetExpectedDeliveryService implements Update<InventoryEntryEntity> {

  /**
   * set expected delivery.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    ZonedDateTime expectedDelivery = ((SetExpectedDelivery) action).getExpectedDelivery();
    entity.setExpectedDelivery(expectedDelivery);
  }
}
