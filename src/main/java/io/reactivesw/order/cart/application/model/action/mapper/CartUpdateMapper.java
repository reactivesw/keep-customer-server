package io.reactivesw.order.cart.application.model.action.mapper;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.Map;

/**
 * Created by umasuo on 16/12/15.
 */
public interface CartUpdateMapper extends Update<CartEntity> {

  /**
   * ImmutableMap for cart update mapper.
   */
  Map<Class<?>, CartUpdateMapper> updateMappers = ImmutableMap.of(
  );

  /**
   * use update mapper to update the entity data.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  static void mapData(CartEntity cart, UpdateAction action) {
    Update updateMapper = updateMappers.get(action.getClass());
    if (updateMapper != null) {
      updateMapper.handle(cart, action);
    }
  }

  /**
   * @param clazz
   * @return
   */
  static CartUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }

}
