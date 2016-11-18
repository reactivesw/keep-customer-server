package io.reactivesw.customer.server.cart.models.draft;

import io.reactivesw.customer.server.common.types.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/18.
 */
@ApiModel
public class ExternalLineItemTotalPrice {

  @ApiModelProperty(required = true)
  private Money price;

  @ApiModelProperty(required = true)
  private Money totalPrice;
}
