package io.reactivesw.orders.carts.models;

import io.reactivesw.common.models.Reference;
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Reference getState() {
    return state;
  }

  public void setState(Reference state) {
    this.state = state;
  }
}
