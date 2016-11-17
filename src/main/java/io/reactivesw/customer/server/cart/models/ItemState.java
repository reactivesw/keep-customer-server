package io.reactivesw.customer.server.cart.models;

import io.reactivesw.customer.server.common.types.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "For item states we also need the information how much of the quantity is affected by this state.")
public class ItemState {


  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(value = "Reference to a State", required = true)
  private Reference state;

}
