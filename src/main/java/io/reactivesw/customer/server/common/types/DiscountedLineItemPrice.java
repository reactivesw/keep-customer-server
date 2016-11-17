package io.reactivesw.customer.server.common.types;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountedLineItemPrice {

  @ApiModelProperty(required = true)
  private Money value;

  @ApiModelProperty(required = true)
  private List<DiscountedLineItemPortion> includedDiscounts;
}
