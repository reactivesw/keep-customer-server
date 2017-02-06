package io.reactivesw.order.payment.application.model.mapper;

import com.braintreegateway.Transaction;
import com.google.api.client.util.Lists;
import com.sun.jndi.cosnaming.CNCtx;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.payment.application.model.TransactionModel;
import io.reactivesw.order.payment.domain.entity.value.TransactionValue;
import io.reactivesw.order.payment.infrastructure.enums.TransactionState;
import io.reactivesw.order.payment.infrastructure.enums.TransactionType;
import io.reactivesw.order.zone.application.model.Zone;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/1/5.
 */
public final class TransactionMapper {
  /**
   * Instantiates a new TransactionModel mapper.
   */
  private TransactionMapper() {
  }

  /**
   * conversion factor.
   */
  private static BigDecimal conversionFactor = new BigDecimal("100");

  /**
   * Entity to model list.
   *
   * @param entities the entities
   * @return the list
   */
  public static List<TransactionModel> entityToModel(List<TransactionValue> entities) {
    List<TransactionModel> models = Lists.newArrayList();

    if (entities != null) {
      models = entities.parallelStream().map(
          entity -> {
            return entityToModel(entity);
          }
      ).collect(Collectors.toList());
    }

    return models;
  }

  /**
   * Entity to model transaction model.
   *
   * @param entity the entity
   * @return the transaction model
   */
  public static TransactionModel entityToModel(TransactionValue entity) {
    TransactionModel model = new TransactionModel();

    model.setId(entity.getId());
    model.setTimestamp(entity.getTimestamp());
    model.setType(entity.getType());
    model.setAmount(MoneyMapper.entityToModel(entity.getAmount()));
    model.setInteractionId(entity.getInteractionId());
    model.setState(entity.getState());

    return model;
  }


  /**
   * Of transaction value.
   *
   * @param transaction the transaction
   * @return the transaction value
   */
  public static TransactionValue of(Transaction transaction) {
    // TODO: 17/2/6
    TransactionValue result = new TransactionValue();

    Calendar time = transaction.getCreatedAt();

    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(time.toInstant(), ZoneOffset.UTC);

    result.setTimestamp(zonedDateTime);


    BigDecimal amount = transaction.getAmount();
    Integer centAmount = Integer.valueOf(amount.multiply(new BigDecimal("100")).intValue());

    result.setAmount(new MoneyEntity(transaction.getCurrencyIsoCode(), centAmount));
    result.setInteractionId(transaction.getId());
    
    result.setType(TransactionType.Charge);
    result.setState(TransactionState.Success);

    return result;
  }


  /**
   * Entity to model transaction.
   *
   * @param entity the entity
   * @return the transaction
   */
  public static TransactionModel entityToModel(Transaction entity) {
    TransactionModel model = new TransactionModel();

    model.setId(entity.getId());
    model.setTimestamp(ZonedDateTime.ofInstant(entity.getCreatedAt().toInstant(),
        ZoneId.systemDefault()));

    model.setState(getTransactionState(entity));
    model.setAmount(getAmount(entity));
    model.setType(getTransactionType(entity));
    model.setInteractionId(null);

    return model;
  }

  private static TransactionState getTransactionState(Transaction entity) {
    TransactionState transactionState = TransactionState.Pending;
    if (entity.getStatus().equals(Transaction.Status
        .SUBMITTED_FOR_SETTLEMENT)) {
      transactionState = TransactionState.Success;
    } else if (entity.getStatus().equals(Transaction.Status.FAILED)) {
      transactionState = TransactionState.Failure;
    }
    return transactionState;
  }

  private static Money getAmount(Transaction entity) {
    Money amount = new Money();

    amount.setCurrencyCode(entity.getCurrencyIsoCode());
    amount.setCentAmount(entity.getAmount().multiply(conversionFactor).intValue());

    return amount;
  }

  private static TransactionType getTransactionType(Transaction entity) {
    TransactionType transactionType = null;

    // TODO: 17/1/5

    return transactionType;
  }
}
