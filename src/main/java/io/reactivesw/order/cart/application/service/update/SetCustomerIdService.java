package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetCustomerId;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import org.springframework.stereotype.Service;

/**
 * Sets the customer ID of the cart. When the customer ID is set, the LineItem prices are updated.
 * Customer with the given ID must exist in the project.
 * Created by umasuo on 16/12/19.
 */
@Service(value = CartUpdateActionUtils.SET_CUSTOMER_ID)
public class SetCustomerIdService extends CartUpdateService {
  /**
   * set the customer id, then update the price and merge the customer's active cart.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    SetCustomerId setCustomerId = (SetCustomerId) action;
    String customerId = setCustomerId.getCustomerId();
    //TODO if this customer already have an active cart, then merge them.
    cart.setCustomerId(customerId);
  }

}
