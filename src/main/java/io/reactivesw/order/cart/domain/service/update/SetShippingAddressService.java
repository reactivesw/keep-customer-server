package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetShippingAddress;
import io.reactivesw.order.cart.application.model.mapper.AddressMapper;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.ShippingAddressValue;

import java.util.Objects;

/**
 * Sets the shipping address of the cart. Setting the shipping address also sets the TaxRate of
 * the line items and calculates the TaxedPrice. If the address is not provided, the shipping
 * address is unset, the taxedPrice is unset and the taxRates are unset in all line items.
 * Created by umasuo on 16/12/19.
 */
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
    Address address = shippingAddress.getAddress();

    if (Objects.isNull(address)) {
      unsetShippingAddress(cart);
    } else {
      setShippingAddress(cart, AddressMapper.modelToShippingAddress(address));
    }
  }

  /**
   * update the address, then set the tax rate and taxed price automatically
   *
   * @param cart    CartEntity
   * @param address ShippingAddressValue
   */
  private void setShippingAddress(CartEntity cart, ShippingAddressValue address) {
    ShippingAddressValue addressValue = cart.getShippingAddress();

    if (addressValue != null) {
      address.setId(addressValue.getId());

    }
    cart.setShippingAddress(address);

    this.setTaxRate(cart);
  }

  /**
   * unset the address, then unset the tax rate and taxed price automatically
   *
   * @param cart
   */
  private void unsetShippingAddress(CartEntity cart) {

    //TODO we should delete the data in ShippingAddressValue table
    cart.setShippingAddress(null);

    this.unsetTaxRate(cart);
  }

  /**
   * set the tax rate.
   *
   * @param cart CartEntity
   */
  private void setTaxRate(CartEntity cart) {
    //TODO select the tax rate, and recalculate the taxed price.
    //TODO the calculate action should be provided by Recalculate Service.
    cart.setTaxedPrice(null);
  }

  /**
   * unset tax rate.
   *
   * @param cart CartEntity
   */
  private void unsetTaxRate(CartEntity cart) {
    //TODO unset the tax rate, and recalculate the taxed price.
    //TODO the calculate action should be provided by Recalculate Service.
    cart.setTaxedPrice(null);
  }
}
