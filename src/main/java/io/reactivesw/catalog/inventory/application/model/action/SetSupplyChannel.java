package io.reactivesw.catalog.inventory.application.model.action;

import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/12/21.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SetSupplyChannel implements UpdateAction {
  /**
   * The Supply channel.
   */
  @NotNull
  private Reference supplyChannel;

  @Override
  public String getActionName() {
    return InventoryEntryActionUtils.SET_SUPPLY_CHANNEL;
  }
}
