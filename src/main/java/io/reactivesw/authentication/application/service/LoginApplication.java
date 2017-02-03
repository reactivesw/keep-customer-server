package io.reactivesw.authentication.application.service;

import io.reactivesw.authentication.application.model.LoginResult;
import io.reactivesw.authentication.infrastructure.util.JwtUtil;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.exception.PasswordErrorException;
import io.reactivesw.customer.customer.application.model.Customer;
import io.reactivesw.customer.customer.infrastructure.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 17/1/21.
 */
@Service
public class LoginApplication {


  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(LoginApplication.class);

  /**
   * login Rest client.
   */
  @Autowired
  private transient RestClient restClient;

  /**
   * JWT(json web token) util
   */
  @Autowired
  private transient JwtUtil jwtUtil;


  /**
   * login with email and password.
   *
   * @param email    String
   * @param password String
   * @return LoginResult
   */
  public LoginResult loginWithEmail(String email, String password) {
    LOG.debug("enter: email: {}", email);
    Customer customer = this.getLegalCustomer(email, password);

    String token = this.jwtUtil.generateToken(customer);

    LoginResult result = new LoginResult(customer, token);

    return result;
  }

  /**
   * login with google token.
   *
   * @param gToken String
   * @return LoginResult
   */
  public LoginResult loginWithGoogle(String gToken) {
    Customer customer = this.getLegalCustomer(gToken);

    String token = this.jwtUtil.generateToken(customer);

    LoginResult result = new LoginResult(customer, token);

    return result;
  }

  /**
   * get legal customer from customer service.
   *
   * @param email    String
   * @param password String
   * @return Customer
   */
  private Customer getLegalCustomer(String email, String password) {
    Customer customer = restClient.getCustomerByEmail(email);
    if (customer == null) {
      //TODO return error message.
      throw new NotExistException("Customer Not exist.");
    }

    Boolean pwdResult = PasswordUtil.checkPassword(password, customer.getPassword());
    if (!pwdResult) {
      throw new PasswordErrorException("password or email not correct.");
    }

    return customer;
  }

  /**
   * get legal customer with google token.
   *
   * @param gToken String google token.
   * @return Customer
   */
  private Customer getLegalCustomer(String gToken) {
    Customer customer = this.restClient.getCustomerByGoogleToken(gToken);
    if (customer == null) {
      //TODO return error message.
      throw new NotExistException("Customer Not exist.");
    }
    return customer;
  }

}
