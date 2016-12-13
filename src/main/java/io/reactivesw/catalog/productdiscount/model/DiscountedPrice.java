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

  /**
   * Gets value.
   *
   * @return the value
   */
  public Money getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(Money value) {
    this.value = value;
  }

  /**
   * Gets discount.
   *
   * @return the discount
   */
  public Reference getDiscount() {
    return discount;
  }

  /**
   * Sets discount.
   *
   * @param discount the discount
   */
  public void setDiscount(Reference discount) {
    this.discount = discount;
  }
}
