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
public class SetRestockableInDays implements UpdateAction {
  /**
   * The Restockable in days.
   */
  @Min(1)
  private Integer restockableInDays;

  @Override
  public String getActionName() {
    return null;
  }
}
