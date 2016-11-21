package io.reactivesw.customer.server.cart.models.orders;

import java.util.List;

import io.reactivesw.customer.server.common.models.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class PaymentInfo {

  @ApiModelProperty(required = true)
  private List<Reference> payments;

  public List<Reference> getPayments() {
    return payments;
  }

  public void setPayments(List<Reference> payments) {
    this.payments = payments;
  }
}
