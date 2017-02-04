package io.reactivesw.order.payment.application.model.mapper;

import com.braintreegateway.Transaction;

import io.reactivesw.order.payment.application.model.Payment;
import io.reactivesw.order.payment.domain.entity.PaymentEntity;

/**
 * Created by Davis on 17/2/4.
 */
public final class PaymentMapper {
  /**
   * Instantiates a new Payment mapper.
   */
  private PaymentMapper() {
  }

  /**
   * Of payment entity.
   *
   * @param transaction the transaction
   * @return the payment entity
   * TODO
   */
  public static PaymentEntity of(Transaction transaction) {
    PaymentEntity entity = new PaymentEntity();

    return entity;
  }

  /**
   * map payment entity to model.
   * @param entity payment entity
   * @return payment model
   * TODO
   */
  public static Payment entityToModel(PaymentEntity entity) {
    Payment model = new Payment();

    return model;
  }
}
