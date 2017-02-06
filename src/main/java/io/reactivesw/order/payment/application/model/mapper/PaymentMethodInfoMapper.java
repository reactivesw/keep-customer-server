package io.reactivesw.order.payment.application.model.mapper;

import com.braintreegateway.Transaction;
import com.google.common.collect.Sets;

import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import io.reactivesw.order.payment.application.model.PaymentMethodInfo;
import io.reactivesw.order.payment.domain.entity.value.PaymentMethodInfoValue;

/**
 * Created by Davis on 17/2/6.
 */
public final class PaymentMethodInfoMapper {
  /**
   * Instantiates a new Payment method info mapper.
   */
  private PaymentMethodInfoMapper() {
  }

  /**
   * Of payment method info value.
   *
   * @param transaction the transaction
   * @return the payment method info value
   */
  public static PaymentMethodInfoValue of(Transaction transaction) {
    PaymentMethodInfoValue result = new PaymentMethodInfoValue();

    String method = transaction.getPaymentInstrumentType();
    result.setMethod(method);
    LocalizedStringEntity name = new LocalizedStringEntity("en", method);
    result.setName(Sets.newHashSet(name));
    // TODO: 17/2/6 set payment intreface
    result.setPaymentInterface(null);

    return result;
  }

  /**
   * Entity to model payment method info.
   *
   * @param entity the entity
   * @return the payment method info
   */
  public static PaymentMethodInfo entityToModel(PaymentMethodInfoValue entity) {
    PaymentMethodInfo model = new PaymentMethodInfo();

    model.setPaymentInterface(entity.getPaymentInterface());
    model.setMethod(entity.getMethod());
    model.setName(LocalizedStringMapper.entityToModelDefaultNull(entity.getName()));

    return model;
  }
}
