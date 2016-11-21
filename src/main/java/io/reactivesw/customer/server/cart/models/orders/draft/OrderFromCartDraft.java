package io.reactivesw.customer.server.cart.models.orders.draft;

import io.reactivesw.customer.server.cart.enums.orders.PaymentState;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
public class OrderFromCartDraft {

  @ApiModelProperty(value = "The unique id of the carts from which an order is created.", required = true)
  private String id;

  @ApiModelProperty(required = true)
  private Integer version;

  @ApiModelProperty(value = "String that uniquely identifies an order. " +
          "It can be used to create more human-readable (in contrast to ID) identifier for the order." +
          " It should be unique across a project. Once it’s set it cannot be changed.",
          required = false)
  private String orderNumber;

  @ApiModelProperty(required = false)
  private PaymentState paymentState;

}