package io.reactivesw.order.order.application.model;

import io.reactivesw.order.order.infrastructure.enums.PaymentState;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
public class OrderFromCartDraft {

  @ApiModelProperty(value = "The unique id of the cart from which an order is created.", required = true)
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public PaymentState getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(PaymentState paymentState) {
    this.paymentState = paymentState;
  }
}
