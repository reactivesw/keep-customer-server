package io.reactivesw.order.discountcode.application.model.action;

import io.reactivesw.common.model.UpdateAction;

import javax.validation.constraints.NotNull;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetActive implements UpdateAction {


  /**
   * is active.
   */
  @NotNull
  private Boolean isActive;

  /**
   * Gets active.
   *
   * @return the active
   */
  public Boolean getActive() {
    return isActive;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(Boolean active) {
    isActive = active;
  }

  @Override
  public String getActionName() {
    return null;
  }
}
