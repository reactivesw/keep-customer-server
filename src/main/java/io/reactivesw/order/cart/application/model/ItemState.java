package io.reactivesw.order.cart.application.model;

import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "For item state we also need the information how much of the quantity is " +
    "affected by this state.")
@Data
public class ItemState {

  @ApiModelProperty(required = true)
  private Integer availableQuantity;

}
