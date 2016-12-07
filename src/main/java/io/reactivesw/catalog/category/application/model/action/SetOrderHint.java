package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by Davis on 16/12/6.
 */
public class SetOrderHint
    implements UpdateAction {
  /**
   * The Order hint.
   */
  private String orderHint;

  /**
   * Gets order hint.
   *
   * @return the order hint
   */
  public String getOrderHint() {
    return orderHint;
  }

  /**
   * Sets order hint.
   *
   * @param orderHint the order hint
   */
  public void setOrderHint(String orderHint) {
    this.orderHint = orderHint;
  }
}
