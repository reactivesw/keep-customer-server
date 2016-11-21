package io.reactivesw.customer.server.cart.models.payments;

import io.reactivesw.customer.server.common.types.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
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
