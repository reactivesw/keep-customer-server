package io.reactivesw.customer.server.common.types;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountedLineItemPriceForQuantity {

  @ApiModelProperty(required = true)
  private Float quantity;

  @ApiModelProperty(required = true)
  private DiscountedLineItemPrice discountedPrice;
}