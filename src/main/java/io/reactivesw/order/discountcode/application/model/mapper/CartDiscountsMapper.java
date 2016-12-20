package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.action.SetCartDiscounts;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umasuo on 16/12/7.
 */
public class CartDiscountsMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   * set cart discounts.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(DiscountCodeEntity entity, UpdateAction action) {
    SetCartDiscounts discounts = (SetCartDiscounts) action;
    List<String> references = new ArrayList<>();
    discounts.getCartDiscounts().parallelStream().forEach(reference -> {
      references.add(reference.getId());
    });

  }
}
