package io.reactivesw.order.cartdiscount.application.model.action.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.SetSortOrder;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by umasuo on 16/12/22.
 */
public class SetSortOrderMapper implements CartDiscountUpdateMapper {

  /**
   * set sort order.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(CartDiscountEntity entity, UpdateAction action) {

    SetSortOrder setSortOrder = (SetSortOrder) action;

    if (StringUtils.isNotBlank(setSortOrder.getSortOrder())) {
      entity.setSortOrder(setSortOrder.getSortOrder());
    }

  }
}
