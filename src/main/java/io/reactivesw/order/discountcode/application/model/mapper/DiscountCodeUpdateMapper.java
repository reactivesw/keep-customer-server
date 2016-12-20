package io.reactivesw.order.discountcode.application.model.mapper;


import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.Update;
import io.reactivesw.order.discountcode.application.model.action.SetActive;
import io.reactivesw.order.discountcode.application.model.action.SetCartDiscounts;
import io.reactivesw.order.discountcode.application.model.action.SetCartPredicate;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplications;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplicationsPerCustomer;

import java.util.Map;

/**
 * Created by umasuo on 16/12/7.
 */
public interface DiscountCodeUpdateMapper<E> extends Update<E> {

  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, DiscountCodeUpdateMapper> updateMappers = ImmutableMap.of(
      SetActive.class, new ActiveMapper(),
      SetCartDiscounts.class, new CartDiscountsMapper(),
      SetCartPredicate.class, new CartPredicateMapper(),
      SetMaxApplications.class, new MaxApplicationsMapper(),
      SetMaxApplicationsPerCustomer.class, new MaxApplicationsPerCustomerMapper()
  );

  /**
   * @param clazz
   * @return
   */
  static DiscountCodeUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}
