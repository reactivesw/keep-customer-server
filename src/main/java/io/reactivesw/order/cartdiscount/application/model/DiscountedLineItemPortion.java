package io.reactivesw.order.cartdiscount.application.model;

import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountedLineItemPortion {

  @ApiModelProperty(value = "Reference to a CartDiscount", required = true)
  private Reference discount;

  @ApiModelProperty(required = true)
  private Money discountedAmount;

  public Reference getDiscount() {
    return discount;
  }

  public void setDiscount(Reference discount) {
    this.discount = discount;
  }

  public Money getDiscountedAmount() {
    return discountedAmount;
  }

  public void setDiscountedAmount(Money discountedAmount) {
    this.discountedAmount = discountedAmount;
  }
}
