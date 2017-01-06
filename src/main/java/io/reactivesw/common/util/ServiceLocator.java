package io.reactivesw.common.util;

import org.springframework.stereotype.Component;

/**
 * this used to locate each service.
 * TODO this should be replaced by register service.
 * Created by umasuo on 17/1/6.
 */
@Component
public class ServiceLocator {

  /**
   * default url.
   */
  public String defaultUrl = "http://localhost:8088";

  /**
   * get cart service.
   *
   * @return
   */
  public String getCart() {
    return defaultUrl;
  }

  /**
   * get product service location.
   *
   * @return String
   */
  public String getProduct() {
    return defaultUrl;
  }

  /**
   * get tax category service location.
   *
   * @return String
   */
  public String getTaxCategory() {
    return defaultUrl;
  }

  /**
   * get shipping method method service location.
   *
   * @return String
   */
  public String getShippingMethod() {
    return defaultUrl;
  }

  /**
   * get Zone.
   *
   * @return String
   */
  public String getZone() {
    return defaultUrl;
  }

  /**
   * get Payment.
   *
   * @return String
   */
  public String getPayment() {
    return defaultUrl;
  }

  /**
   * get order.
   *
   * @return String
   */
  public String getOrder() {
    return defaultUrl;
  }

  /**
   * get Customer.
   *
   * @return String
   */
  public String getCustomer() {
    return defaultUrl;
  }
}
