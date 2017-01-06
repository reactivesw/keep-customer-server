package io.reactivesw.order.order.application.model;

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
