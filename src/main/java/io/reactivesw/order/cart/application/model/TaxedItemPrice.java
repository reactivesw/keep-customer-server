package io.reactivesw.order.cart.application.model;

import io.reactivesw.common.model.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "TaxedItemPrice fields can not be used in query predicates.\n")
@Data
public class TaxedItemPrice {

  @ApiModelProperty(required = true)
  private Money totalNet;

  @ApiModelProperty(required = true)
  private Money totalGross;

}
