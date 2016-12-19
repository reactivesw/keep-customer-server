package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.exception.ImmutableException;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.SetCustomerId;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.infrastructure.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Sets the customer ID of the cart. When the customer ID is set, the LineItem prices are updated.
 * Customer with the given ID must exist in the project.
 * Created by umasuo on 16/12/19.
 */
@Service
public class SetCustomerIdService extends CartUpdateService {

  /**
   * cart repository.
   */
  @Autowired
  private transient CartRepository cartRepository;

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

    if (customerId == null) {
      throw new ImmutableException("Can not unset the customer id of an cart");
    }

    Optional<CartEntity> optional = cartRepository.findByCustomerIdAndCartState(customerId,
        CartState.Active).parallelStream().findFirst();

    if (optional.isPresent()) {
      CartEntity cartInDb = optional.get();
      this.mergeCart(cart, cartInDb);
      //delete the unnecessary cart, each customer only has one active cart
      this.cartRepository.delete(cartInDb);
    }
    cart.setCustomerId(customerId);
  }

  /**
   * merge additional cart to base cart.
   *
   * @param baseCart       CartEntity
   * @param additionalCart CartEntity
   */
  private void mergeCart(CartEntity baseCart, CartEntity additionalCart) {
    //TODO merge the two cart
    baseCart.setTotalPrice(additionalCart.getTotalPrice());
  }
}
