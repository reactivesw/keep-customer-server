package io.reactivesw.order.discountcode.application.model.action;

import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/7.
 */
public class SetMaxApplicationsPerCustomer implements UpdateAction {

  /**
   * If the maxApplicationsPerCustomer parameter is not included, the field will be emptied.
   */
  private Integer maxApplicationsPerCustomer;

  /**
   * Gets max application per customer.
   *
   * @return the max application per customer
   */
  public Integer getMaxApplicationsPerCustomer() {
    return maxApplicationsPerCustomer;
  }

  /**
   * Sets max application per customer.
   *
   * @param maxApplicationsPerCustomer the max application per customer
   */
  public void setMaxApplicationsPerCustomer(Integer maxApplicationsPerCustomer) {
    this.maxApplicationsPerCustomer = maxApplicationsPerCustomer;
  }
}
