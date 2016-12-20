package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetCountry;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * Sets the country of the cart. When the country is set, the LineItem prices are updated.
 * Created by umasuo on 16/12/19.
 */
public class SetCountryService extends CartUpdateService {


  /**
   * recalculate service.
   */
  @Autowired
  private transient RecalculateService recalculate;

  /**
   * set or unset the country.
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetCountry setCountry = (SetCountry) action;
    String country = setCountry.getCountry();

    if (Objects.isNull(country)) {
      cart.setCountry(null);
    } else {
      cart.setCountry(country);
      recalculate.calculate(cart);
    }
  }
}
