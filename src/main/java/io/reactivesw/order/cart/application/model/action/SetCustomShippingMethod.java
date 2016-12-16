package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.ExternalTaxRateDraft;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import lombok.Data;

/**
 * Sets a custom shipping method (independent of the ShippingMethods defined in the project).
 * The custom shipping method can be unset with the setShippingMethod action without the
 * shippingMethod.
 * <p>
 * <b>Prerequisite</b>: The cart must contain a shipping address.
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomShippingMethod {

  /**
   * name.
   */
  String shippingMethodName;

  /**
   * The shipping rate used to determine the price.
   */
  ShippingRate shippingRate;

  /**
   * Reference to a TaxCategory.
   * The given tax category will be used to select a tax rate when a cart has the TaxMode Platform.
   */
  Reference taxCategory;

  /**
   * An external tax rate can be set if the cart has the External TaxMode.
   */
  ExternalTaxRateDraft externalTaxRate;

}
