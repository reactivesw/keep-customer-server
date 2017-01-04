package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetShippingAddress;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import org.springframework.stereotype.Service;

/**
 * Sets the shipping address of the cart. Setting the shipping address also sets the TaxRate of
 * the line items and calculates the TaxedPrice. If the address is not provided, the shipping
 * address is unset, the taxedPrice is unset and the taxRates are unset in all line items.
 * Created by umasuo on 16/12/19.
 */
@Service(value = CartUpdateActionUtils.SET_SHIPPING_ADDRESS)
public class SetShippingAddressService extends CartUpdateService {

  /**
   * set or unset the shipping address.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetShippingAddress shippingAddress = (SetShippingAddress) action;
    String addressId = shippingAddress.getAddressId();

    cart.setShippingAddress(addressId);
  }
}
