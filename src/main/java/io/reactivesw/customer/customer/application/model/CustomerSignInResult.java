package io.reactivesw.customer.customer.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.reactivesw.order.cart.application.model.Cart;
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }
}
