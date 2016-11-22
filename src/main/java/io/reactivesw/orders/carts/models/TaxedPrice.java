package io.reactivesw.orders.carts.models;

import java.util.List;

import io.reactivesw.common.models.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "TaxedPrice fields that can be used in query predicates: totalNet, totalGross.")
public class TaxedPrice {

  @ApiModelProperty(required = true)
  private Money totalNet;

  @ApiModelProperty(required = true)
  private Money totalGross;

  @ApiModelProperty(required = true)
  private List<TaxPortion> taxPortions;

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

  public List<TaxPortion> getTaxPortions() {
    return taxPortions;
  }

  public void setTaxPortions(List<TaxPortion> taxPortions) {
    this.taxPortions = taxPortions;
  }
}
