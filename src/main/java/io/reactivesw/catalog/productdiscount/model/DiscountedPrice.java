package io.reactivesw.catalog.productdiscount.model;

import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
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
