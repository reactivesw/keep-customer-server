package io.reactivesw.common.model.mapper;

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
 * Created by umasuo on 16/12/7.
 */
public interface UpdateMapper<E> {

  /**
   * put the value in action to entity.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  public void setAction(E entity, UpdateAction action);
}
