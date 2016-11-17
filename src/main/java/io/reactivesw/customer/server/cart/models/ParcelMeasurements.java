package io.reactivesw.customer.server.cart.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "Information regarding the dimensions of a parcel.")
public class ParcelMeasurements {

  @ApiModelProperty(required = true)
  private Float heightInMillimeter;

  @ApiModelProperty(required = true)
  private Float lengthInMillimeter;

  @ApiModelProperty(required = true)
  private Float widthInMillimeter;

  @ApiModelProperty(required = true)
  private Float weightInGram;
}
