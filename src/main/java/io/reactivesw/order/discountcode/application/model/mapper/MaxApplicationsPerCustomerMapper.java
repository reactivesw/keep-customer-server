package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplicationsPerCustomer;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class MaxApplicationsPerCustomerMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   * set maxApplicationsPerCustomer.
   * If the maxApplicationsPerCustomer parameter is not included, the field will be emptied.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(DiscountCodeEntity entity, UpdateAction action) {
    entity.setMaxApplicationsPerCustomer(((SetMaxApplicationsPerCustomer) action)
        .getMaxApplicationsPerCustomer());
  }
}
