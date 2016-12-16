package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.ExternalTaxRateDraft;
import io.reactivesw.common.model.CustomFieldsDraft;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class AddCustomLineItem {

  /**
   * name.
   */
  LocalizedString name;

  /**
   * quantity.
   */
  Integer quantity;

  /**
   * money.
   */
  Money money;

  /**
   * slug.
   */
  String slug;

  /**
   * Reference to a TaxCategory - Required only for Platform TaxMode
   * The given tax category will be used to select a tax rate when a cart has the tax mode Platform.
   */
  Reference taxCategory;

  /**
   * An external tax rate can be set if the cart has the External TaxMode.
   */
  ExternalTaxRateDraft externalTaxRate;

  /**
   * The custom fields.
   */
  CustomFieldsDraft custom;

}
