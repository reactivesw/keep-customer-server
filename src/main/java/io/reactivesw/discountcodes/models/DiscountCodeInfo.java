package io.reactivesw.discountcodes.models;

import io.reactivesw.common.models.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountCodeInfo {

  @ApiModelProperty(value = "Reference to a DiscountCode", required = true)
  private Reference discountCode;

  @ApiModelProperty(required = false)
  private DiscountCodeState state;
}