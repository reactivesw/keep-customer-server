package io.reactivesw.customer.customer.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.customer.customer.application.model.action.SetCustomerPaymentId;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetCustomerPaymentIdMapper implements CustomerUpdateMapper {

  /**
   * set location.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CustomerEntity entity, UpdateAction action) {
    SetCustomerPaymentId paymentIdAction = (SetCustomerPaymentId) action;
    entity.setPaymentId(paymentIdAction.getPaymentId());
  }

}
