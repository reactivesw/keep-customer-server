package io.reactivesw.order.shippingmethod.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.reactivesw.common.model.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "The shipping is free if the order total (the sum of line item prices) " +
    "exceeds the freeAbove value.")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingRate {

  @ApiModelProperty(required = true)
  private Money price;

  @ApiModelProperty(value = "The shipping will be free if the LineItem TotalPrice is above this")
  private Money freeAbove;

}
