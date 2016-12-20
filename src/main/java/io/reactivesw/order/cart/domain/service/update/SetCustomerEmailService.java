package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetCustomerEmail;
import io.reactivesw.order.cart.domain.entity.CartEntity;

/**
 * Created by umasuo on 16/12/19.
 */
public class SetCustomerEmailService extends CartUpdateService {

  /**
   * set customer email
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetCustomerEmail setCustomerEmail = (SetCustomerEmail) action;
    cart.setCustomerEmail(setCustomerEmail.getEmail());
  }
}
