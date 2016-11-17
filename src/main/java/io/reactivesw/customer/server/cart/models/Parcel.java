package io.reactivesw.customer.server.cart.models;

import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A parcel stores the information about the appearance and the movement of a parcel")
public class Parcel {

  @ApiModelProperty(value = "Unique id of the parcel", required = true)
  private String id;

  @ApiModelProperty(required = true)
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = false)
  private ParcelMeasurements measurements;

  @ApiModelProperty(required = false)
  private TrackingData trackingData;

}
