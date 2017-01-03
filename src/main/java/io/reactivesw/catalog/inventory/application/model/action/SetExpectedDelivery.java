package io.reactivesw.catalog.inventory.application.model.action;

import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/12/21.
 */
@Data
@EqualsAndHashCode
public class SetExpectedDelivery implements UpdateAction {
  /**
   * The Expected delivery.
   */
  private ZonedDateTime expectedDelivery;

  @Override
  public String getActionName() {
    return InventoryEntryActionUtils.SET_EXPECTED_DELIVERY;
  }
}
