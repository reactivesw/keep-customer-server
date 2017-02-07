package io.reactivesw.order.order.application.service;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.order.infrastructure.validator.CartValidator;
import io.reactivesw.order.payment.application.model.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Davis on 17/2/6.
 */
@Component
public class OrderRestClient {

  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(OrderRestClient.class);
  
  /**
   * RestTemplate.
   */
  @Autowired
  @Qualifier("restTemplate")
  private transient RestTemplate restTemplate;

  /**
   * Gets cart.
   *
   * @param cartId  the cart id
   * @param version the cart version
   * @return the cart
   */
  public Cart getCart(String cartId, Integer version) {
    LOG.debug("enter getCart, cart id is : {}, cart version is : {}", cartId, version);

    String url = "http://localhost:8088/carts/" + cartId;
    Cart result = restTemplate.getForObject(url, Cart.class);

    CartValidator.validateVersion(result, version);

    LOG.debug("end getCart, result is : {}", result);
    return result;
  }


  /**
   * Checkout payment.
   *
   * @param centAmount         the cent amount
   * @param paymentMethodToken the payment method token
   * @return the payment
   */
  public Payment checkout(String customerId, Integer centAmount, String paymentMethodToken) {
    LOG.debug("enter checkout, centAmount is : {}, payment method token is : {}", centAmount,
        paymentMethodToken);

    String url = "http://localhost:8088/payments";
    MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
    request.add("customerId", customerId);
    request.add("amount", String.valueOf(centAmount));
    request.add("token", paymentMethodToken);

    Payment result = restTemplate.postForObject(url, request, Payment.class);
    LOG.debug("end checkout, result is : {}", result);
    return result;
  }

  /**
   * Change inventory entry inventory entry.
   *
   * @return the inventory entry
   */
  public InventoryEntry changeInventoryEntry() {
    LOG.debug("enter changeInventoryEntry");

    // TODO: 17/2/6
    InventoryEntry result = null;
    
    LOG.debug("end changeInventoryEntry");

    return result;
  }
}
