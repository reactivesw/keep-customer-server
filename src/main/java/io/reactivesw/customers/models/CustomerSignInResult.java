package io.reactivesw.customers.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.reactivesw.orders.carts.application.models.Cart;
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

  @ApiModelProperty(value = "A carts that is associated to the customer. Empty if the customer does not have a carts yet.", required = false)
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
