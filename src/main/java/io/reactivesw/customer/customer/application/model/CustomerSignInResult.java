package io.reactivesw.customer.customer.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.reactivesw.order.cart.application.model.Cart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CustomerSignInResult {

  @ApiModelProperty(value = "Customer info.")
  @JsonProperty
  private Customer customer;

}
