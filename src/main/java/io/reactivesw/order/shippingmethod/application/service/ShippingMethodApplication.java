package io.reactivesw.order.shippingmethod.application.service;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.Address;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService;
import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.route.CartRouter;
import io.reactivesw.route.ZoneRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * application services.
 * Created by umasuo on 16/12/20.
 */
@Service
public class ShippingMethodApplication {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ShippingMethodApplication.class);

  /**
   * rest caller.
   */
  private transient RestTemplate restTemplate = new RestTemplate();

  /**
   * shipping method domain service.
   */
  @Autowired
  private transient ShippingMethodService service;

  /**
   * get by country and state.
   *
   * @param country String
   * @param state   String
   * @return List of ShippingMethodEntity
   */
  public List<ShippingMethodEntity> getByLocation(String country, String state) {
    LOG.debug("enter: country: {}, state: {}", country, state);

    List<Zone> zones = restTemplate.getForObject(buildUrl(country, state), List.class);

    List<List<ShippingMethodEntity>> entities = zones.parallelStream().map(
        zone -> service.getByLocation(zone.getId())
    ).collect(Collectors.toList());

    List<ShippingMethodEntity> methods = new ArrayList<>();
    entities.parallelStream().forEach(
        shippingMethodEntities -> methods.addAll(shippingMethodEntities)
    );

    LOG.debug("exit: shipping methods: {}", methods);
    return methods;
  }

  /**
   * Retrieves all the shipping methods that can ship to the given Location.
   * If the currency parameter is given, then the shipping methods must also have a rate defined
   * in the specified currency.
   *
   * @param country  String
   * @param state    String
   * @param currency currency code in String
   * @return list of ShippingMethodEntity
   */
  public List<ShippingMethodEntity> getByLocation(String country, String state, String currency) {
    LOG.debug("enter: country: {}, state: {}, currency: {}", country, state, currency);
    List<Zone> zones = restTemplate.getForObject(buildUrl(country, state), List.class);

    List<List<ShippingMethodEntity>> entities = zones.parallelStream().map(
        zone -> service.getByLocation(zone.getId(), currency)
    ).collect(Collectors.toList());

    List<ShippingMethodEntity> methods = new ArrayList<>();
    entities.parallelStream().forEach(
        shippingMethodEntities -> methods.addAll(shippingMethodEntities)
    );

    LOG.debug("exit: shipping methods: {}", methods);
    return methods;
  }


  /**
   * get shipping address for a cart whose shipping address had been set.
   *
   * @param cartId id for cart
   * @return List of ShippingMethodEntity
   */
  public List<ShippingMethodEntity> getShippingMethodsForCart(String cartId) {
    LOG.debug("enter: cartId: {}", cartId);
    Address address = restTemplate.getForObject(buildUrl(cartId), Address.class);
    if (address == null) {
      LOG.warn("The shipping address of the cart must been set: cartId: {}", cartId);
      throw new NotExistException("The shipping address of the cart must been set.");
    }
    String country = address.getCountry();
    String state = address.getState();

    return this.getByLocation(country, state);
  }

  /**
   * rest template setter.
   *
   * @param restTemplate RestTemplate
   */
  protected void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * build the resource url.
   *
   * @param country String
   * @param state   String
   * @return String
   */
  private String buildUrl(String country, String state) {
    //TODO use the service register for this
    StringBuffer result = new StringBuffer();
    result.append(ZoneRouter.ZONE_BASE_URL)
        .append("?country=").append(country)
        .append("&state=").append(state);
    return result.toString();
  }

  /**
   * build the resource url.
   *
   * @param cartId String
   * @return String
   */
  private String buildUrl(String cartId) {
    //TODO use the service register for this
    return CartRouter.CART_SHIPPING_ADDRESS.replace(CartRouter.ID_PATTERN, cartId);
  }
}
