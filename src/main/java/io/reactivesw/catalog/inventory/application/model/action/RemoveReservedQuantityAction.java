package io.reactivesw.catalog.inventory.application.model.action;

import io.reactivesw.common.model.UpdateAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;

/**
 * Created by Davis on 16/12/22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RemoveReservedQuantityAction implements UpdateAction {
  /**
   * The Reserved.
   */
  @Min(1)
  private int removeReservedQuantity;

  @Override
  public String getActionName() {
    return null;
  }
}
