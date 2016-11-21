package io.reactivesw.carts.models;

import io.reactivesw.common.models.Money;
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

  public Money getPrice() {
    return price;
  }

  public void setPrice(Money price) {
    this.price = price;
  }

  public Money getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Money totalPrice) {
    this.totalPrice = totalPrice;
  }
}
