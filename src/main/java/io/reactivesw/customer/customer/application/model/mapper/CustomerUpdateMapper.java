package io.reactivesw.customer.customer.application.model.mapper;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.Update;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;

import java.util.Map;

/**
 * Created by umasuo on 17/2/7.
 */
public interface CustomerUpdateMapper extends Update<CustomerEntity> {
  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, CustomerUpdateMapper> updateMappers = ImmutableMap.of(
      SetCustomerPaymentIdMapper.class, new SetCustomerPaymentIdMapper()
  );

  /**
   * get mapper.
   *
   * @param clazz UpdateAction class
   * @return ZoneUpdateMapper
   */
  static CustomerUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}
