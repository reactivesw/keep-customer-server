package io.reactivesw.customer.server.cart.models.carts;

import io.reactivesw.customer.server.common.models.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "TaxedItemPrice fields can not be used in query predicates.\n")
public class TaxedItemPrice {

  @ApiModelProperty(required = true)
  private Money totalNet;

  @ApiModelProperty(required = true)
  private Money totalGross;

  public Money getTotalNet() {
    return totalNet;
  }

  public void setTotalNet(Money totalNet) {
    this.totalNet = totalNet;
  }

  public Money getTotalGross() {
    return totalGross;
  }

  public void setTotalGross(Money totalGross) {
    this.totalGross = totalGross;
  }
}
