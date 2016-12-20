package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetLocale;
import io.reactivesw.order.cart.domain.entity.CartEntity;

/**
 * Sets the locale. Must be one of the languages supported for this Project.
 * Created by umasuo on 16/12/20.
 */
public class SetLocaleService extends CartUpdateService {

  /**
   * set or unset the locale.
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetLocale setLocale = (SetLocale) action;
    String locale = setLocale.getLocale();

    //TODO check if the locale supported by the project
    cart.setLocale(locale);
  }
}
