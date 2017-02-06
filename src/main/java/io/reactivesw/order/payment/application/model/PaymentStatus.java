package io.reactivesw.order.payment.application.model;

import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
@Getter
@Setter
public class PaymentStatus {

  @ApiModelProperty(value = "A code describing the current status returned by the interface that processes the payment.",
          required = false)
  private String interfaceCode;

  @ApiModelProperty(value = "A text describing the current status returned by the interface that processes the payment.",
          required = false)
  private String interfaceText;

  @ApiModelProperty(required = false)
  private Reference state;
}
