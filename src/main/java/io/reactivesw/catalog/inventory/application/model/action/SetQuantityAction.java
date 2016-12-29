package io.reactivesw.catalog.inventory.application.model.action;

import io.reactivesw.common.model.UpdateAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;

/**
 * Created by Davis on 16/12/21.
 */
@Data
@EqualsAndHashCode
public class SetQuantityAction implements UpdateAction {
  /**
   * The Quantity.
   */
  @Min(0)
  private Integer quantity;

  @Override
  public String getActionName() {
    return null;
  }
}
