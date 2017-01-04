package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.ExternalTaxRateDraft;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.Reference;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetShippingMethod implements UpdateAction {

  /**
   * Reference to a ShippingMethod.
   */
  private Reference shippingMethod;

}
