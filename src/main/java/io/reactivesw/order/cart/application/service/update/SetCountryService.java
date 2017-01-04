package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetCountry;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import org.springframework.stereotype.Service;

/**
 * Sets the country of the cart. When the country is set, the LineItem prices are updated.
 * Created by umasuo on 16/12/19.
 */
@Service(value = CartUpdateActionUtils.SET_COUNTRY)
public class SetCountryService extends CartUpdateService {


  /**
   * set or unset the country.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetCountry setCountry = (SetCountry) action;
    String country = setCountry.getCountry();
    //TODO check the correction of the country
    cart.setCountry(country);
  }
}
