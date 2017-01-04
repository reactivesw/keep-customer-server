package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetBillingAddress;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/19.
 */
@Service(value = CartUpdateActionUtils.SET_BILLING_ADDRESS)
public class SetBillingAddressService extends CartUpdateService {


  /**
   * set or unset billing address.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetBillingAddress billingAddress = (SetBillingAddress) action;

    String addressId = billingAddress.getAddressId();

    cart.setBillingAddress(addressId);

  }
}
