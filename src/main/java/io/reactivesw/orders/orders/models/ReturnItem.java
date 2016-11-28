package io.reactivesw.orders.orders.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.reactivesw.orders.orders.enums.ReturnPaymentState;
import io.reactivesw.orders.orders.enums.ReturnShipmentState;
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

  public String getLineItemId() {
    return lineItemId;
  }

  public void setLineItemId(String lineItemId) {
    this.lineItemId = lineItemId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public ReturnShipmentState getShipmentState() {
    return shipmentState;
  }

  public void setShipmentState(ReturnShipmentState shipmentState) {
    this.shipmentState = shipmentState;
  }

  public ReturnPaymentState getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(ReturnPaymentState paymentState) {
    this.paymentState = paymentState;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
