package io.reactivesw.order.cart.application.service;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.taxcategory.application.model.TaxCategory;
import io.reactivesw.common.model.Address;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.zone.application.model.Zone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Davis on 16/12/22.
 */
@Component
public class CartRestClient {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartRestClient.class);

  /**
   * RestTemplate.
   */
  @Autowired
  @Qualifier("restTemplate")
  private transient RestTemplate restTemplate;

  /**
   * Gets Address from customer service.
   *
   * @param addressId the address id
   * @return the Address
   */
  public Address getAddress(String addressId) {
    LOG.debug("enter: addressId: {}", addressId);
    String url = "http://localhost:8088/customers/addresses/" + addressId;
    Address address = restTemplate.getForObject(url, Address.class);
    LOG.debug("exit: Address: {}", address);
    return address;
  }

  /**
   * Gets product data from product service.
   *
   * @param productId the address id
   * @return the Product
   */
  public Product getProduct(String productId) {
    LOG.debug("enter: productId: {}", productId);
    String url = "http://localhost:8088/products/" + productId;
    Product product = restTemplate.getForObject(url, Product.class);
    LOG.debug("exit: product: {}", product);
    return product;
  }

  /**
   * Gets product data from product service.
   *
   * @param zoneId the zone id
   * @return the Product
   */
  public Zone getZone(String zoneId) {
    LOG.debug("enter: zoneId: {}", zoneId);
    String url = "http://localhost:8088/zones/" + zoneId;
    Zone zone = restTemplate.getForObject(url, Zone.class);
    LOG.debug("exit: zone: {}", zone);
    return zone;
  }

  /**
   * Gets tax category id.
   *
   * @param categoryId the tax category id
   * @return the Zone
   */
  public TaxCategory getTaxCategory(String categoryId) {
    LOG.debug("enter: categoryId: {}", categoryId);
    String url = "http://localhost:8088/tax-categories/" + categoryId;
    TaxCategory taxCategory = restTemplate.getForObject(url, TaxCategory.class);
    LOG.debug("enter: taxCategory: {}", taxCategory);
    return taxCategory;
  }

  /**
   * Gets tax category id.
   *
   * @param methodId the tax category id
   * @return the Zone
   */
  public ShippingMethod getShippingMethod(String methodId) {
    LOG.debug("enter: methodId: {}", methodId);
    String url = "http://localhost:8088/shipping-methods/" + methodId;
    ShippingMethod shippingMethod = restTemplate.getForObject(url, ShippingMethod.class);
    LOG.debug("enter: shippingMethod: {}", shippingMethod);
    return shippingMethod;
  }

}
