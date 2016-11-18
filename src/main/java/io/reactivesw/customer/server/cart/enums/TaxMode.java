package io.reactivesw.customer.server.cart.enums;

/**
 * Values of the TaxMode enumeration:
 * Created by umasuo on 16/11/17.
 */
public enum TaxMode {
  /**
   * The tax rates are selected by the platform from the TaxCategories based on the cart shipping
   * address.
   */
  Platform,

  /**
   * The tax rates are set externally per ExternalTaxRateDraft. A cart with this tax mode can only
   * be ordered if all line items, all custom line items and the shipping method have an external
   * tax rate set.
   */
  External,
  /**
   * No taxes are added to the cart.
   */
  Disabled;

}
