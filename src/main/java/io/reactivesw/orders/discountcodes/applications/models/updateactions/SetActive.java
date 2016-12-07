package io.reactivesw.orders.discountcodes.applications.models.updateactions;

import io.reactivesw.common.models.UpdateAction;

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
}
