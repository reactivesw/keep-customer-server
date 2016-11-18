package io.reactivesw.customer.server.cart.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "Tracking data is usually some info about the delivery (like a DHL tracking number) which is useful to keep an eye on your delivery, view its status, etc.")
public class TrackingData {

  @ApiModelProperty(value = "The id to track one parcel.", required = false)
  private String trackingId;

  @ApiModelProperty(value = "The carrier that delivers the parcel.", required = false)
  private String carrier;

  @ApiModelProperty(value = " Optional The name of the provider which serves as facade to several carriers.", required = false)
  private String provider;

  @ApiModelProperty(value = "Optional The id of the transaction with the provider.", required = false)
  private String providerTransaction;

  @ApiModelProperty(value = "Flag to distinguish if the parcel is on the way to the customer (false) or on the way back (true).",
          required = false)
  private Boolean isReturn;

}
