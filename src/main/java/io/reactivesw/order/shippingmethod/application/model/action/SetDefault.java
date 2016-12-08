package io.reactivesw.order.shippingmethod.application.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetDefault implements UpdateAction {

  /**
   * The Is default.
   */
  private Boolean isDefault;

  /**
   * Gets default.
   *
   * @return the default
   */
  public Boolean getDefault() {
    return isDefault;
  }

  /**
   * Sets default.
   *
   * @param aDefault the a default
   */
  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }
}
