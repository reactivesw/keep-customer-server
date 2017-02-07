package io.reactivesw.order.payment.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(PaymentRestClient.class);

  /**
   * rest template.
   */
  @Autowired
  @Qualifier("restTemplate")
  private transient RestTemplate restTemplate;

  /**
   * get braintree customer id.
   *
   * @param customerId system customer id
   * @return braintree customer id
   */
  public String getPaymentAccountId(String customerId) {
    LOG.debug("enter getPaymentAccountId, customer id is : {}", customerId);

    String url = "http://localhost:8088/customers/" + customerId + "/payments";

    String paymentAccountId = restTemplate.getForObject(url, String.class);

    LOG.debug("end getPaymentAccountId, get id is : {}", paymentAccountId);

    return paymentAccountId;
  }

  /**
   * save braintree customer id.
   *
   * @param customerId       system customer id
   * @param paymentAccountId braintree customer id
   */
  public void savePaymentAccountId(String customerId, String paymentAccountId) {
    LOG.debug("enter savePaymentAccountId, customer id is : {}, payment account id is : {}",
        customerId, paymentAccountId);

    LOG.debug("end savePaymentAccountId");
  }
}
