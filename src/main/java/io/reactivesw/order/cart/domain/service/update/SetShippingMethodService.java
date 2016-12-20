package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.exception.ImmutableException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetShippingMethod;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;

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

    SetShippingMethod shippingMethod = (SetShippingMethod) action;
    String shippingMethodId = shippingMethod.getShippingMethod() == null ? null : shippingMethod
        .getShippingMethod().getId();

    if (shippingMethodId == null) {
      this.unsetShippingMethod(cart);
    } else {
      // TODO get the shipping method from shipping method service
      ShippingMethodEntity shippingMethodEntity = new ShippingMethodEntity();
      this.setShippingMethod(cart, shippingMethodEntity);
    }

    //TODO set the external tax rate
    //    ExternalTaxRateDraft externalTaxRate = shippingMethod.getExternalTaxRate();

  }

  /**
   * set shipping method.
   *
   * @param cart           CartEntity
   * @param shippingMethod ShippingMethodEntity
   */
  private void setShippingMethod(CartEntity cart, ShippingMethodEntity shippingMethod) {
    ShippingInfoValue shippingInfo = cart.getShippingInfo();

    if (shippingInfo == null) {
      shippingInfo = new ShippingInfoValue();
    }

    shippingInfo.setShippingMethodName(shippingMethod.getName());
    shippingInfo.setShippingMethod(shippingMethod.getId());
    shippingInfo.setTaxCategory(shippingMethod.getTaxCategory());

    cart.setShippingInfo(shippingInfo);
  }

  /**
   * unset shipping method.
   *
   * @param cart CartEntity
   */
  private void unsetShippingMethod(CartEntity cart) {

    ShippingInfoValue shippingInfo = cart.getShippingInfo();

    if (shippingInfo == null) {
      throw new NotExistException("Shipping method not set yet");
    }

    shippingInfo.setShippingMethodName(null);
    shippingInfo.setShippingMethod(null);
    shippingInfo.setTaxCategory(null);

    cart.setShippingInfo(shippingInfo);
  }


}
