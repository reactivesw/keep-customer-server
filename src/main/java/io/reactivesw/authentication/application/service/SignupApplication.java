package io.reactivesw.authentication.application.service;

import io.reactivesw.authentication.application.model.LoginResult;
import io.reactivesw.authentication.infrastructure.util.JwtUtil;
import io.reactivesw.customer.customer.application.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 17/1/23.
 */
@Service
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
   * jwt tool for generate token.
   */
  @Autowired
  private transient JwtUtil jwtUtil;

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

    String token = jwtUtil.generateToken(customer);

    LoginResult loginResult = new LoginResult(customer, token);

    return loginResult;
  }
}
