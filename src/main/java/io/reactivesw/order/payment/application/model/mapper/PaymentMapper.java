package io.reactivesw.order.payment.application.model.mapper;

import com.braintreegateway.Transaction;
import com.google.common.collect.Lists;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.payment.application.model.Payment;
import io.reactivesw.order.payment.domain.entity.PaymentEntity;
import io.reactivesw.order.payment.domain.entity.value.TransactionValue;

import java.math.BigDecimal;

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
  public static PaymentEntity of(String amount, String customerId, Transaction transaction) {
    PaymentEntity entity = new PaymentEntity();

    entity.setCustomerId(customerId);
    entity.setExternalId(null);
    entity.setInterfaceId(null);
    entity.setAmountPlanned(new MoneyEntity("USD", Integer.parseInt(amount)));
    entity.setAmountAuthorized(null);
    entity.setAuthorizedUntil(null);
    entity.setAmountPaid(ofTransaction(transaction));
    entity.setAmountRefunded(null);
    entity.setPaymentMethodInfo(PaymentMethodInfoMapper.of(transaction));
    entity.setPaymentStatus(PaymentStatusMapper.of(transaction));
    entity.setTransactions(Lists.newArrayList(TransactionMapper.of(transaction)));

    return entity;
  }

  private static MoneyEntity ofTransaction(Transaction transaction) {
    MoneyEntity result = new MoneyEntity();

    result.setCurrencyCode(transaction.getCurrencyIsoCode());

    BigDecimal amount = transaction.getAmount();

    Integer centAmount = amount.multiply(new BigDecimal("100")).intValue();

    result.setCentAmount(centAmount);

    return result;
  }

  /**
   * map payment entity to model.
   * @param entity payment entity
   * @return payment model
   */
  public static Payment entityToModel(PaymentEntity entity) {
    Payment model = new Payment();

    model.setId(entity.getId());
    model.setVersion(entity.getVersion());
    model.setCustomer(new Reference(ReferenceTypes.CUSTOMER.toString(), entity.getCustomerId()));
    model.setExternalId(entity.getExternalId());
    model.setInterfaceId(entity.getInterfaceId());
    model.setAmountPlanned(MoneyMapper.entityToModel(entity.getAmountPlanned()));
    model.setAmountAuthorized(MoneyMapper.entityToModel(entity.getAmountAuthorized()));
    model.setAuthorizedUntil(entity.getAuthorizedUntil());
    model.setAmountPaid(MoneyMapper.entityToModel(entity.getAmountPaid()));
    model.setAmountRefunded(MoneyMapper.entityToModel(entity.getAmountRefunded()));
    model.setPaymentMethodInfo(PaymentMethodInfoMapper.entityToModel(entity.getPaymentMethodInfo
        ()));
    model.setPaymentStatus(PaymentStatusMapper.entityToModel(
        entity.getPaymentStatus()
    ));
    model.setTransactions(TransactionMapper.entityToModel(entity.getTransactions()));
    model.setInterfaceInteractions(null);
    model.setCustom(null);
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());

    return model;
  }
}
