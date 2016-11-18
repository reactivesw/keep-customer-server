package io.reactivesw.customer.server.cart.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.reactivesw.customer.server.cart.enums.ReturnPaymentState;
import io.reactivesw.customer.server.cart.enums.ReturnShipmentState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class ReturnItem {

  @ApiModelProperty(required = true)
  private String id;

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(required = true)
  private String lineItemId;

  @ApiModelProperty(required = true)
  private String comment;

  @ApiModelProperty(required = true)
  private ReturnShipmentState shipmentState;

  @ApiModelProperty(required = true)
  private ReturnPaymentState paymentState;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

}
