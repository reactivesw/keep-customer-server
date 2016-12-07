package io.reactivesw.orders.discountcodes.applications.models.updateactions;

import io.reactivesw.common.models.UpdateAction;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetMaxApplications implements UpdateAction {

  /**
   * If the maxApplications parameter is not included, the field will be emptied.
   */
  private Integer maxApplications;

  /**
   * Gets max applications.
   *
   * @return the max applications
   */
  public Integer getMaxApplications() {
    return maxApplications;
  }

  /**
   * Sets max applications.
   *
   * @param maxApplications the max applications
   */
  public void setMaxApplications(Integer maxApplications) {
    this.maxApplications = maxApplications;
  }
}
