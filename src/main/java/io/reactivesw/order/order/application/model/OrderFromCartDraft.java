package io.reactivesw.order.order.application.model;

import io.reactivesw.order.order.infrastructure.enums.PaymentState;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by umasuo on 16/11/17.
 */
@Getter
@Setter
@ToString
public class OrderFromCartDraft {

  @ApiModelProperty(value = "The unique id of the cart from which an order is created.", required = true)
  private String id;

  @ApiModelProperty(required = true)
  private Integer version;

  @ApiModelProperty(value = "String that uniquely identifies an order. " +
          "It can be used to create more human-readable (in contrast to ID) identifier for the order." +
          " It should be unique across a merchant. Once it’s set it cannot be changed.",
          required = false)
  private String orderNumber;

  @ApiModelProperty(required = false)
  private PaymentState paymentState;

  @ApiModelProperty(value = "payment method token", required = false)
  private String paymentMethodToken;
}
