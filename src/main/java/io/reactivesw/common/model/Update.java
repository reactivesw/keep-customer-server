package io.reactivesw.common.model;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.action.SetActive;
import io.reactivesw.order.discountcode.application.model.action.SetCartDiscounts;
import io.reactivesw.order.discountcode.application.model.action.SetCartPredicate;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplications;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplicationsPerCustomer;
import io.reactivesw.order.discountcode.application.model.mapper.ActiveMapper;
import io.reactivesw.order.discountcode.application.model.mapper.CartDiscountsMapper;
import io.reactivesw.order.discountcode.application.model.mapper.CartPredicateMapper;
import io.reactivesw.order.discountcode.application.model.mapper.MaxApplicationsMapper;
import io.reactivesw.order.discountcode.application.model.mapper.MaxApplicationsPerCustomerMapper;

import java.util.Map;

/**
 * we may got two kind of update: just use the data in action, or still use data from other service.
 * if we just use the data in action, we can only use action mapper to set the data.
 * if we need get data from other palace, we should use update service.
 * Created by umasuo on 16/12/7.
 */
public interface Update<E> {

  /**
   * put the value in action to entity.
   *
   * @param entity E
   * @param action UpdateAction
   */
  void handle(E entity, UpdateAction action);
}
