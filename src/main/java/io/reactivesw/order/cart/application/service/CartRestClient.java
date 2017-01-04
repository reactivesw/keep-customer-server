package io.reactivesw.order.cart.application.service;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.taxcategory.application.model.TaxCategory;
import io.reactivesw.common.model.Address;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.zone.application.model.Zone;
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
    String url = "http://localhost:8088/customers/addresses/" + addressId;
    return restTemplate.getForObject(url, Address.class);
  }

  /**
   * Gets product data from product service.
   *
   * @param productId the address id
   * @return the Product
   */
  public Product getProduct(String productId) {
    String url = "http://localhost:8088/products/" + productId;
    return restTemplate.getForObject(url, Product.class);
  }

  /**
   * Gets product data from product service.
   *
   * @param zoneId the zone id
   * @return the Product
   */
  public Zone getZone(String zoneId) {
    String url = "http://localhost:8088/zones/" + zoneId;
    return restTemplate.getForObject(url, Zone.class);
  }

  /**
   * Gets tax category id.
   *
   * @param categoryId the tax category id
   * @return the Zone
   */
  public TaxCategory getTaxCategory(String categoryId) {
    String url = "http://localhost:8088/tax-categories/" + categoryId;
    return restTemplate.getForObject(url, TaxCategory.class);
  }

  /**
   * Gets tax category id.
   *
   * @param methodId the tax category id
   * @return the Zone
   */
  public ShippingMethod getShippingMethod(String methodId) {
    String url = "http://localhost:8088/shipping-methods/" + methodId;
    return restTemplate.getForObject(url, ShippingMethod.class);
  }


}
