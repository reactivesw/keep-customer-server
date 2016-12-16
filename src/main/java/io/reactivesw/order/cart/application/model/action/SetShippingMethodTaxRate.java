package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.ExternalTaxRateDraft;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetShippingMethodTaxRate {

  private ExternalTaxRateDraft externalTaxRate;
}
