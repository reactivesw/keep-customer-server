package io.reactivesw.order.cart.application.model;

import java.util.List;

import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
@Data
public class PaymentInfo {

  @ApiModelProperty(required = true)
  private List<Reference> payments;

}
