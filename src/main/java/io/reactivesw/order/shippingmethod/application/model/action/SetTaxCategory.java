package io.reactivesw.order.shippingmethod.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.Reference;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetTaxCategory implements UpdateAction {

  /**
   * reference of a tax category.
   */
  private Reference taxCategory;

  /**
   * Gets tax category.
   *
   * @return the tax category
   */
  public Reference getTaxCategory() {
    return taxCategory;
  }

  /**
   * Sets tax category.
   *
   * @param taxCategory the tax category
   */
  public void setTaxCategory(Reference taxCategory) {
    this.taxCategory = taxCategory;
  }

  @Override
  public String getActionName() {
    return null;
  }
}
