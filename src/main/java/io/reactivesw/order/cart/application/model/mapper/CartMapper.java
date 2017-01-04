package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by umasuo on 16/12/5.
 */
public class CartMapper {

  /**
   * convert entity to model.
   * only map the basic info: id, version,time, customerId, anonymousId, state, taxMode, country
   *
   * @param entity CartEntity
   * @return Cart
   */
  public static Cart entityToModel(CartEntity entity) {
    Cart cart = null;
    if (entity != null) {
      cart = new Cart();
      cart.setId(entity.getId());
      cart.setVersion(entity.getVersion());
      cart.setCreatedAt(entity.getCreatedAt());
      cart.setLastModifiedAt(entity.getLastModifiedAt());
      cart.setCustomerId(entity.getCustomerId());
      cart.setAnonymousId(entity.getAnonymousId());
      cart.setCartState(entity.getCartState());
      cart.setTaxMode(entity.getTaxMode());
      cart.setCountry(entity.getCountry());
      cart.setCurrencyCode(entity.getCurrencyCode());
    }
    return cart;
  }


}
