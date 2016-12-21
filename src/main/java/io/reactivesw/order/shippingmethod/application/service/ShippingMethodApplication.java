package io.reactivesw.order.shippingmethod.application.service;

import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService;
import io.reactivesw.order.zone.application.model.Zone;
import io.reactivesw.route.ZoneRouter;
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
   * rest caller.
   */
  private transient RestTemplate restTemplate = new RestTemplate();

  /**
   * shipping method domain service.
   */
  @Autowired
  private transient ShippingMethodService service;

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
    List<Zone> zones = restTemplate.getForObject(buildUrl(country, state), List.class);

    List<List<ShippingMethodEntity>> entities = zones.parallelStream().map(
        zone -> service.getByLocation(zone.getId(), currency)
    ).collect(Collectors.toList());

    List<ShippingMethodEntity> methods = new ArrayList<>();
    entities.parallelStream().forEach(
        shippingMethodEntities -> methods.addAll(shippingMethodEntities)
    );
    return methods;
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
   * @param country
   * @param state
   * @return
   */
  private String buildUrl(String country, String state) {
    //TODO use the service register for this
    StringBuffer result = new StringBuffer();
    result.append(ZoneRouter.ZONE_BASE_URL)
        .append("?country=").append(country)
        .append("&state=").append(state);
    return result.toString();
  }
}
