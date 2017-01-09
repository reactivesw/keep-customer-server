package io.reactivesw.order.order.application.model;

import io.reactivesw.order.order.infrastructure.enums.ReturnShipmentState;
import io.swagger.annotations.ApiModelProperty;

/**
 * The ReturnItemDraft needs to be given with the Add ReturnInfo update method. At this point only
 * Advised or Returned ReturnShipmentState is allowed. Item with Advised shipment state gets the
 * NonRefundable ReturnPaymentState and item with Returned shipment state gets Initial payment
 * state.
 * Created by umasuo on 16/11/17.
 */
public class ReturnItemDraft {

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(required = true)
  private String lineItemId;

  @ApiModelProperty(required = false)
  private String comment;

  @ApiModelProperty(required = true)
  private ReturnShipmentState shipmentState;

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
}
