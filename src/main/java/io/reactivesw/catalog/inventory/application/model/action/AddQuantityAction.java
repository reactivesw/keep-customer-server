package io.reactivesw.catalog.inventory.application.model.action;

import io.reactivesw.catalog.inventory.infrastructure.util.InventoryEntryActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/12/21.
 */
@Data
@EqualsAndHashCode
public class AddQuantityAction implements UpdateAction {
  /**
   * The Quantity.
   */
  @NotNull
  @Min(1)
  private Integer quantity;

  @Override
  public String getActionName() {
    return InventoryEntryActionUtils.ADD_QUANTITY;
  }
}
