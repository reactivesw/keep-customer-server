package io.reactivesw.order.payment.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Davis on 17/2/3.
 */
@Service
public class PaymentRestClient {
  /**
   * rest template.
   */
  @Autowired
  @Qualifier("restTemplate")
  private transient RestTemplate restTemplate;

  /**
   * get braintree customer id.
   * @param customerId system customer id
   * @return braintree customer id
   */
  public String getBraintreeCustomerId(String customerId) {
    // TODO: 17/2/3
//    LOG.debug("enter getBraintreeCustomerId, system customer id is : {}" + subjectId);

    restTemplate.delete("");

//    LOG.debug("end getBraintreeCustomerId");

    return "";
  }

  /**
   * save braintree customer id.
   * @param customerId system customer id
   * @param braintreeCustomerId braintree customer id
   */
  public void saveBraintreeCustomerId(String customerId, String braintreeCustomerId) {
    // TODO: 17/2/3
  }
}
