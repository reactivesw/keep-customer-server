package io.reactivesw.customer.server.catalog.models;

import io.reactivesw.customer.server.common.types.Money;
import io.reactivesw.customer.server.common.types.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountedPrice {

  @ApiModelProperty(required = true)
  private Money value;
  @ApiModelProperty(required = true, reference = "Reference")
  private Reference discount;
}
