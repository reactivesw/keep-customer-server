package io.reactivesw.order.cart.domain.service.update;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.Update;
import io.reactivesw.order.cart.application.model.action.mapper.CartUpdateMapper;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by umasuo on 16/12/16.
 */
@Service
public class CartUpdateService implements Update<CartEntity> {

  /**
   * ImmutableMap for cart update service.
   */
  private transient Map<Class<?>, Update> updateMappers = ImmutableMap.of();

  /**
   * use update service or updateMapper to update the entity.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    Update updateService = updateMappers.get(action.getClass());
    if (updateService == null) {
      //use the data
      CartUpdateMapper.mapData(cart, action);
    } else {
      updateService.handle(cart, action);

    }
  }

}
