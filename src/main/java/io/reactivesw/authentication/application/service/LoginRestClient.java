package io.reactivesw.authentication.application.service;

import io.reactivesw.common.util.ServiceLocator;
import io.reactivesw.customer.customer.application.model.Customer;
import io.reactivesw.route.CustomerRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by umasuo on 17/1/21.
 */
@Component
public class LoginRestClient {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(LoginRestClient.class);

  /**
   * RestTemplate.
   */
  private transient RestTemplate restTemplate = new RestTemplate();

  /**
   * service locator.
   * //TODO we should use register to replace this.
   */
  @Autowired
  private transient ServiceLocator serviceLocator;

  /**
   * Gets Address from customer service.
   *
   * @param email the address id
   */
  public Customer getCustomerByEmail(String email) {
    LOG.debug("enter: email: {}", email);

    String url = serviceLocator.getCustomer() + CustomerRouter.getCustomerWithEmail(email);
    Customer customer = restTemplate.getForObject(url, Customer.class);

    LOG.debug("exit: customer: {}", customer);
    return customer;
  }

  /**
   * google token.
   *
   * @param gToken String
   * @return Customer
   */
  public Customer getCustomerByGoogleToken(String gToken) {
    LOG.debug("enter: google token: {}", gToken);

    String url = serviceLocator.getCustomer() + CustomerRouter.getCustomerWithGoogle(gToken);
    Customer customer = restTemplate.getForObject(url, Customer.class);

    return customer;
  }


}
