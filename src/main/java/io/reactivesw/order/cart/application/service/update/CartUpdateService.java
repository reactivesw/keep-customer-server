package io.reactivesw.order.cart.application.service.update;

import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 16/12/16.
 */
@Service
public class CartUpdateService implements Update<CartEntity> {

  /**
   * application context.
   */
  @Autowired
  private transient ApplicationContext context;

  /**
   * use update service or updateMapper to update the entity.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    handle(cart, action, context);
  }

}
