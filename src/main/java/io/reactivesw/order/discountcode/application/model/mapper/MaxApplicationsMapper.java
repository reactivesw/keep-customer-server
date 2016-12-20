package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplications;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class MaxApplicationsMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   * set max applications.
   * If the maxApplications parameter is not included, the field will be emptied.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(DiscountCodeEntity entity, UpdateAction action) {
    entity.setMaxApplications(((SetMaxApplications) action).getMaxApplications());
  }
}
