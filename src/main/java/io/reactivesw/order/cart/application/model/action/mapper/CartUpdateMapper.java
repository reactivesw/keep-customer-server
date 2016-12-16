package io.reactivesw.order.cart.application.model.action.mapper;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.mapper.UpdateMapper;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.Map;

/**
 * Created by umasuo on 16/12/15.
 */
public interface CartUpdateMapper extends UpdateMapper<CartEntity> {

  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, CartUpdateMapper> updateMappers = ImmutableMap.of(
  );

  /**
   * @param clazz
   * @return
   */
  static CartUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }

}
