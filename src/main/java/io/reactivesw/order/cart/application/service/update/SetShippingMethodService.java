package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.exception.ImmutableException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetShippingMethod;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;

import java.util.Objects;

/**
 * Sets the ShippingMethod. Prerequisite: The cart must contain a shipping address.
 * Created by umasuo on 16/12/19.
 */
public class SetShippingMethodService extends CartUpdateService {

  /**
   * set the shipping method.
   * An external tax rate can be set if the cart has the External TaxMode.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {

    if (Objects.isNull(cart.getShippingAddress())) {
      throw new ImmutableException("Cart must contains a shipping address.");
    }

    SetShippingMethod setShippingMethod = (SetShippingMethod) action;
    String shippingMethodId = setShippingMethod.getShippingMethod() == null ? null :
        setShippingMethod
            .getShippingMethod().getId();

    if (shippingMethodId == null) {
      this.unsetShippingMethod(cart);
    } else {
      this.setShippingMethod(cart, shippingMethodId);
    }

    //TODO set the external tax rate

  }

  /**
   * set shipping method.
   *
   * @param cart             CartEntity
   * @param shippingMethodId String
   */
  private void setShippingMethod(CartEntity cart, String shippingMethodId) {

    ShippingInfoValue shippingInfo = this.getShippingInfo(cart);
    
    shippingInfo.setShippingMethod(shippingMethodId);

    cart.setShippingInfo(shippingInfo);
  }

  /**
   * unset shipping method.
   *
   * @param cart CartEntity
   */
  private void unsetShippingMethod(CartEntity cart) {

    ShippingInfoValue shippingInfo = this.getShippingInfo(cart);

    shippingInfo.setShippingMethod(null);

    cart.setShippingInfo(shippingInfo);
  }

  private ShippingInfoValue getShippingInfo(CartEntity cart) {
    ShippingInfoValue shippingInfo = cart.getShippingInfo();
    if (shippingInfo == null) {
      shippingInfo = new ShippingInfoValue();
      cart.setShippingInfo(shippingInfo);
    }
    return shippingInfo;
  }
}
