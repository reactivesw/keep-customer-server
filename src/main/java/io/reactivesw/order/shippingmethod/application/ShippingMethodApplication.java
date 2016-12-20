package io.reactivesw.order.shippingmethod.application;

import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * application services.
 * Created by umasuo on 16/12/20.
 */
@Service
public class ShippingMethodApplication {

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
    //TODO get all locations by country
    String locationId = "";

    //TODO get shipping method for each location
    service.getByLocation(locationId, currency);

    //TODO merge all the list
    return null;
  }
}
