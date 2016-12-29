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
public class AddReservedQuantityAction implements UpdateAction {
  /**
   * The Add reserved quantity.
   */
  @Min(1)
  private int addReservedQuantity;

  @Override
  public String getActionName() {
    return null;
  }
}
