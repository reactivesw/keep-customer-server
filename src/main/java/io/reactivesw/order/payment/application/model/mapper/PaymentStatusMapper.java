package io.reactivesw.order.payment.application.model.mapper;

import com.braintreegateway.Transaction;

import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.payment.application.model.PaymentStatus;
import io.reactivesw.order.payment.domain.entity.value.PaymentStatusValue;

/**
 * Created by Davis on 17/2/6.
 */
public final class PaymentStatusMapper {
  /**
   * Instantiates a new Payment status mapper.
   */
  private PaymentStatusMapper() {
  }

  /**
   * Of payment status value.
   *
   * @param transaction the transaction
   * @return the payment status value
   */
  public static PaymentStatusValue of(Transaction transaction) {

    PaymentStatusValue result = new PaymentStatusValue();

    result.setInterfaceText(transaction.getProcessorResponseText());
    result.setInterfaceCode(transaction.getProcessorResponseCode());
    // TODO: 17/2/6 set status id
    result.setStateId(null);

    return result;
  }

  /**
   * Entity to model payment status.
   *
   * @param entity the entity
   * @return the payment status
   */
  public static PaymentStatus entityToModel(PaymentStatusValue entity) {
    PaymentStatus model = new PaymentStatus();

    model.setInterfaceCode(entity.getInterfaceCode());
    model.setInterfaceText(entity.getInterfaceText());
    model.setState(new Reference(ReferenceTypes.STATE.toString(), entity.getStateId()));

    return model;
  }

}
