package io.reactivesw.order.shippingmethod.application.model;

import java.util.List;

import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
@Getter
@Setter
public class ZoneRate {

  @ApiModelProperty(value = "Reference to a Zone", required = true)
  private Reference zone;

  @ApiModelProperty(value = "The array does not contain two shipping rates with the same currency.",
      required = true)
  private List<ShippingRate> shippingRates;
}
