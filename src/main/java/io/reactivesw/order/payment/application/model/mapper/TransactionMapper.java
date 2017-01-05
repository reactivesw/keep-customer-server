package io.reactivesw.order.payment.application.model.mapper;

import io.reactivesw.common.model.Money;
import io.reactivesw.order.payment.application.model.Transaction;
import io.reactivesw.order.payment.infrastructure.enums.TransactionState;
import io.reactivesw.order.payment.infrastructure.enums.TransactionType;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Davis on 17/1/5.
 */
public final class TransactionMapper {
  /**
   * Instantiates a new Transaction mapper.
   */
  private TransactionMapper() {
  }

  /**
   * conversion factor.
   */
  private static BigDecimal conversionFactor = new BigDecimal("100");

  /**
   * Entity to model transaction.
   *
   * @param entity the entity
   * @return the transaction
   */
  public static Transaction entityToModel(com.braintreegateway.Transaction entity) {
    Transaction model = new Transaction();

    model.setId(entity.getId());
    model.setTimestamp(ZonedDateTime.ofInstant(entity.getCreatedAt().toInstant(),
        ZoneId.systemDefault()));

    model.setState(getTransactionState(entity));
    model.setAmount(getAmount(entity));
    model.setType(getTransactionType(entity));
    model.setInteractionId(null);

    return model;
  }

  private static TransactionState getTransactionState(com.braintreegateway.Transaction entity) {
    TransactionState transactionState = TransactionState.Pending;
    if (entity.getStatus().equals(com.braintreegateway.Transaction.Status
        .SUBMITTED_FOR_SETTLEMENT)) {
      transactionState = TransactionState.Success;
    } else if (entity.getStatus().equals(com.braintreegateway.Transaction.Status.FAILED)) {
      transactionState = TransactionState.Failure;
    }
    return transactionState;
  }

  private static Money getAmount(com.braintreegateway.Transaction entity) {
    Money amount = new Money();

    amount.setCurrencyCode(entity.getCurrencyIsoCode());
    amount.setCentAmount(entity.getAmount().multiply(conversionFactor).intValue());

    return amount;
  }

  private static TransactionType getTransactionType(com.braintreegateway.Transaction entity) {
    TransactionType transactionType = null;

    // TODO: 17/1/5

    return transactionType;
  }
}
