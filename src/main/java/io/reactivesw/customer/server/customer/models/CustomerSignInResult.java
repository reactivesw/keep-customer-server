package io.reactivesw.customer.server.customer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.reactivesw.customer.server.cart.models.Cart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerSignInResult {

  @ApiModelProperty(value = "Customer info.")
  @JsonProperty
  private Customer customer;

  @ApiModelProperty(value = "A cart that is associated to the customer. Empty if the customer does not have a cart yet.", required = false)
  private Cart cart;


}
