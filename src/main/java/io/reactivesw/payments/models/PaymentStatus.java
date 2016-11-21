package io.reactivesw.payments.models;

import io.reactivesw.common.models.Reference;
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

  public String getInterfaceCode() {
    return interfaceCode;
  }

  public void setInterfaceCode(String interfaceCode) {
    this.interfaceCode = interfaceCode;
  }

  public String getInterfaceText() {
    return interfaceText;
  }

  public void setInterfaceText(String interfaceText) {
    this.interfaceText = interfaceText;
  }

  public Reference getState() {
    return state;
  }

  public void setState(Reference state) {
    this.state = state;
  }
}
