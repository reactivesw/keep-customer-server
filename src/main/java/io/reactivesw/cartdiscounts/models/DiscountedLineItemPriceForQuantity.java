package io.reactivesw.cartdiscounts.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountedLineItemPriceForQuantity {

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(required = true)
  private DiscountedLineItemPrice discountedPrice;

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public DiscountedLineItemPrice getDiscountedPrice() {
    return discountedPrice;
  }

  public void setDiscountedPrice(DiscountedLineItemPrice discountedPrice) {
    this.discountedPrice = discountedPrice;
  }
}
