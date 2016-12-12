package io.reactivesw.order.shippingmethod.application.model.mapper;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.common.model.mapper.UpdateMapper;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;

import java.util.Map;

/**
 * Created by umasuo on 16/12/8.
 */
public interface ShippingMethodUpdateMapper extends UpdateMapper<ShippingMethodEntity> {
  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, ShippingMethodUpdateMapper> updateMappers = ImmutableMap.of(
      SetName.class, new SetNameMapper()
  );

  /**
   * get mapper.
   *
   * @param clazz UpdateAction class
   * @return ZoneUpdateMapper
   */
  static ShippingMethodUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}
