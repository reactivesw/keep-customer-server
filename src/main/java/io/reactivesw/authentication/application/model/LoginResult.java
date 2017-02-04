package io.reactivesw.authentication.application.model;

import io.reactivesw.customer.customer.application.model.Customer;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by umasuo on 17/1/10.
 */
@Data
@ApiModel
public class LoginResult {

  /**
   * customer token.
   */
  String token;

  /**
   * customer.
   */
  Customer customer;

  /**
   * default constructor.
   */
  public LoginResult() {
  }

  /**
   * constructor with full data.
   *
   * @param customer Customer
   * @param token    String
   */
  public LoginResult(Customer customer, String token) {
    this.customer = customer;
    this.token = token;
  }
}
