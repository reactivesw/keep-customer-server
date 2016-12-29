package io.reactivesw.order.discountcode.application.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetMaxApplications implements UpdateAction {

  /**
   * If the maxApplications parameter is not included, the field will be emptied.
   */
  private Integer maxApplications;

  /**
   * Gets max application.
   *
   * @return the max application
   */
  public Integer getMaxApplications() {
    return maxApplications;
  }

  /**
   * Sets max application.
   *
   * @param maxApplications the max application
   */
  public void setMaxApplications(Integer maxApplications) {
    this.maxApplications = maxApplications;
  }

  @Override
  public String getActionName() {
    return null;
  }
}
