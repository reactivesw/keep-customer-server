package io.reactivesw.customer.server.cart.models.draft;

import io.reactivesw.customer.server.cart.enums.ReturnShipmentState;
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

}
