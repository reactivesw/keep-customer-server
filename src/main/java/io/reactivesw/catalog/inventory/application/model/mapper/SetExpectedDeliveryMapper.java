package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.action.SetExpectedDelivery;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.model.UpdateAction;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/12/21.
 */
public class SetExpectedDeliveryMapper implements InventoryEntryUpdateMapper<InventoryEntryEntity> {

  @Override
  public void handle(InventoryEntryEntity entity, UpdateAction action) {
    ZonedDateTime expectedDelivery = ((SetExpectedDelivery) action).getExpectedDelivery();
    entity.setExpectedDelivery(expectedDelivery);
  }
}
