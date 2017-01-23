package io.reactivesw.authentication.application.service;

import io.reactivesw.authentication.application.model.LoginResult;
import io.reactivesw.customer.customer.application.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 17/1/23.
 */
@RestController
public class SignupApplication {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(SignupApplication.class);


  /**
   * login Rest client.
   */
  @Autowired
  private transient RestClient restClient;

  /**
   * signup with email.
   *
   * @param email    email
   * @param password password
   * @return Customer
   */
  public LoginResult signupWithEmail(String email, String password) {
    LOG.debug("enter: email: {}", email);

    Customer customer = restClient.createCustomerByEmail(email, password);

    //TODO generate the token
    String token = null;

    LoginResult loginResult = new LoginResult(customer, token);

    return loginResult;
  }
}
