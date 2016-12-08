package io.reactivesw.order.shippingmethod.application.model;

import io.reactivesw.common.model.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "The shipping is free if the order total (the sum of line item prices) exceeds the freeAbove value.")
public class ShippingRate {

  @ApiModelProperty(required = true)
  private Money price;

  @ApiModelProperty(required = false)
  private Money freeAbove;

  public Money getPrice() {
    return price;
  }

  public void setPrice(Money price) {
    this.price = price;
  }

  public Money getFreeAbove() {
    return freeAbove;
  }

  public void setFreeAbove(Money freeAbove) {
    this.freeAbove = freeAbove;
  }
}
