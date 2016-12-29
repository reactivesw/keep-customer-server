package io.reactivesw.catalog.inventory.application.model.action;

import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Davis on 16/12/21.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SetSupplyChannel implements UpdateAction {
  /**
   * The Supply channel.
   */
  private Reference supplyChannel;

  @Override
  public String getActionName() {
    return null;
  }
}
