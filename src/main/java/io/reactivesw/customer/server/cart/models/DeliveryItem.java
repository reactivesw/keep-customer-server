package io.reactivesw.customer.server.cart.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DeliveryItem {

  @ApiModelProperty(value = "ID of a LineItem or a CustomLineItem", required = true)
  private String id;

  @ApiModelProperty(required = true)
  private Integer quantity;
}
