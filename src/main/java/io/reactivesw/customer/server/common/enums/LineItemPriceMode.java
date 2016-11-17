package io.reactivesw.customer.server.common.enums;

import io.swagger.annotations.ApiModel;

/**
 * Created by umasuo on 16/11/17.
 */
public enum LineItemPriceMode {


  /**
   * The price is selected form the product variant. This is the default mode.
   */
  Platform,

  /**
   * The price was set externally. Cart discounts are disabled for the line items with this price
   * mode. Any changes to the line item quantity will reset ìt back to the Platform price mode.
   */
  ExternalTotal;

}
