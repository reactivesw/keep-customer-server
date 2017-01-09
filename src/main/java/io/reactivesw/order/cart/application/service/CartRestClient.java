package io.reactivesw.order.cart.application.service;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.taxcategory.application.model.TaxCategory;
import io.reactivesw.common.util.ServiceLocator;
import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.route.CustomerRouter;
import io.reactivesw.route.ProductRouter;
import io.reactivesw.route.ShippingMethodRouter;
import io.reactivesw.route.TaxCategoryRouter;
import io.reactivesw.route.ZoneRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
  private transient RestTemplate restTemplate = new RestTemplate();

  /**
   * service locator.
   */
  @Autowired
  private transient ServiceLocator serviceLocator;

  /**
   * Gets Address from customer service.
   *
   * @param addressId the address id
   * @return the Address
   */
  public Address getAddress(String addressId) {
    LOG.debug("enter: addressId: {}", addressId);
    String url = serviceLocator.getCustomer() + CustomerRouter.getAddressWithId(addressId);
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
    String url = serviceLocator.getProduct() + ProductRouter.getProductWithId(productId);
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
    String url = serviceLocator.getZone() + ZoneRouter.getZoneWithId(zoneId);
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
    String url = serviceLocator.getTaxCategory() + TaxCategoryRouter.getTaxCategoryWithId
        (categoryId);
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
    String url = serviceLocator.getShippingMethod() + ShippingMethodRouter
        .getShippingMethodWithId(methodId);
    ShippingMethod shippingMethod = restTemplate.getForObject(url, ShippingMethod.class);
    LOG.debug("enter: shippingMethod: {}", shippingMethod);
    return shippingMethod;
  }

}
