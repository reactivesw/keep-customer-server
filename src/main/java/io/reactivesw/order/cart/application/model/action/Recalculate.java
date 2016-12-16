package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class Recalculate {

  /**
   * If set to true, the line item product data (name, variant and productType) will also be
   * updated.
   * If set to false, only the prices and tax rates will be updated.
   */
  private Boolean updateProductData;
}
