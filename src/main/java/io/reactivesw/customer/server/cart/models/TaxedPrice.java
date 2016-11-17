package io.reactivesw.customer.server.cart.models;

import java.util.List;

import io.reactivesw.customer.server.common.types.Money;
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

}
