package io.reactivesw.orders.discountcodes.applications.models;

import io.reactivesw.common.models.Reference;
import io.reactivesw.orders.discountcodes.infrastructures.enums.DiscountCodeState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountCodeInfo {

  @ApiModelProperty(value = "Reference to a DiscountCode", required = true)
  private Reference discountCode;

  @ApiModelProperty(required = false)
  private DiscountCodeState state;

  /**
   * Gets discount code.
   *
   * @return the discount code
   */
  public Reference getDiscountCode() {
    return discountCode;
  }

  /**
   * Sets discount code.
   *
   * @param discountCode the discount code
   */
  public void setDiscountCode(Reference discountCode) {
    this.discountCode = discountCode;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public DiscountCodeState getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(DiscountCodeState state) {
    this.state = state;
  }
}
