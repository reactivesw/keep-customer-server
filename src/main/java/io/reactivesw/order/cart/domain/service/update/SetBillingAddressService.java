package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetBillingAddress;
import io.reactivesw.order.cart.application.model.mapper.AddressMapper;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.Objects;

/**
 * Created by umasuo on 16/12/19.
 */
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

    Address address = billingAddress.getAddress();
    
    if (Objects.isNull(address)) {
      cart.setBillingAddress(null);
    } else {
      cart.setBillingAddress(AddressMapper.modelToBillingAddress(address));
    }
  }
}
