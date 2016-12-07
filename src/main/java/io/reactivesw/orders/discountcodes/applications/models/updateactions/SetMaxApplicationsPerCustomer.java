package io.reactivesw.orders.discountcodes.applications.models.updateactions;

import io.reactivesw.common.models.UpdateAction;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetMaxApplicationsPerCustomer implements UpdateAction {

  /**
   * If the maxApplicationsPerCustomer parameter is not included, the field will be emptied.
   */
  private Integer maxApplicationsPerCustomer;

  /**
   * Gets max applications per customer.
   *
   * @return the max applications per customer
   */
  public Integer getMaxApplicationsPerCustomer() {
    return maxApplicationsPerCustomer;
  }

  /**
   * Sets max applications per customer.
   *
   * @param maxApplicationsPerCustomer the max applications per customer
   */
  public void setMaxApplicationsPerCustomer(Integer maxApplicationsPerCustomer) {
    this.maxApplicationsPerCustomer = maxApplicationsPerCustomer;
  }
}
