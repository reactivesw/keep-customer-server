package io.reactivesw.orders.carts.applications.models;

import io.reactivesw.common.models.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "Represents the portions that sum up to the totalGross field of a TaxedPrice. " +
        "The portions are calculated from the TaxRates. " +
        "If a tax rate has SubRates, they are used and can be identified by name. " +
        "Tax portions from line items that have the same rate and name will be accumulated to the same tax portion.\n" +
        "\n")
public class TaxPortion {

  @ApiModelProperty(required = false)
  private String name;

  @ApiModelProperty(value = "A number in the range [0..1]", required = true)
  private Float rate;

  @ApiModelProperty(required = true)
  private Money amount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getRate() {
    return rate;
  }

  public void setRate(Float rate) {
    this.rate = rate;
  }

  public Money getAmount() {
    return amount;
  }

  public void setAmount(Money amount) {
    this.amount = amount;
  }
}
