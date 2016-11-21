package io.reactivesw.customer.server.cart.models.payments;

import io.reactivesw.customer.server.common.types.LocalizedString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.scene.shape.Line;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class PaymentMethodInfo {

  @ApiModelProperty(value = "The interface that handles the payment (usually a PSP). " +
          "Cannot be changed once it has been set. " +
          "The combination of PaymentinterfaceId and this field must be unique.",
          required = false)
  private String paymentInterface;

  @ApiModelProperty(value = "The payment method that is used, e.g. e.g. a conventional string representing Credit Card, Cash Advance etc.",
          required = false)
  private String method;

  @ApiModelProperty(value = "A human-readable, localized name for the payment method, e.g. ‘Credit Card’.",
          required = false)
  private LocalizedString name;

}
