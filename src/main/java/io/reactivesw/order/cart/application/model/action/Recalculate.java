package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class Recalculate implements UpdateAction {

  /**
   * If set to true, the line item product data (name, variant and productType) will also be
   * updated.
   * If set to false, only the prices and tax rates will be updated.
   */
  private Boolean updateProductData;

  @Override
  public String getActionName() {
    return null;
  }
}
