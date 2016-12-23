package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.common.model.Update;
import io.reactivesw.order.cartdiscount.application.model.action.SetActive;
import io.reactivesw.order.cartdiscount.application.model.action.SetCartPredicate;
import io.reactivesw.order.cartdiscount.application.model.action.SetRequiresDiscountCode;
import io.reactivesw.order.cartdiscount.application.model.action.SetSortOrder;
import io.reactivesw.order.cartdiscount.application.model.action.SetTarget;
import io.reactivesw.order.cartdiscount.application.model.action.SetValidFrom;
import io.reactivesw.order.cartdiscount.application.model.action.SetValidUntil;
import io.reactivesw.order.cartdiscount.application.model.action.SetValue;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

import java.util.Map;

/**
 * Created by umasuo on 16/12/22.
 */
public interface CartDiscountUpdateMapper extends Update<CartDiscountEntity> {

  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, CartDiscountUpdateMapper> updateMappers = ImmutableMap.<Class<?>,
      CartDiscountUpdateMapper>builder()
      .put(SetActive.class, new SetActiveMapper())
      .put(SetCartPredicate.class, new SetCartPredicateMapper())
      .put(SetRequiresDiscountCode.class, new SetRequiresDiscountCodeMapper())
      .put(SetSortOrder.class, new SetSortOrderMapper())
      .put(SetTarget.class, new SetSortOrderMapper())
      .put(SetValidFrom.class, new SetValidFromMapper())
      .put(SetValidUntil.class, new SetValidUntilMapper())
      .put(SetValue.class, new SetValueMapper())
      .build();


  /**
   * get mapper.
   *
   * @param clazz UpdateAction class
   * @return ZoneUpdateMapper
   */
  static CartDiscountUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }

}
