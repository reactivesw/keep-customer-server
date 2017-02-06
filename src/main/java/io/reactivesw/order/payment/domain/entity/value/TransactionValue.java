package io.reactivesw.order.payment.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.payment.infrastructure.enums.TransactionState;
import io.reactivesw.order.payment.infrastructure.enums.TransactionType;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Davis on 17/2/4.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order_payment_transaction")
public class TransactionValue extends BaseIdEntity {
  /**
   * transaction time.
   */
  @Column
  private ZonedDateTime timestamp;

  /**
   * transaction type.
   */
  @Column
  private TransactionType type;

  /**
   * transaction amount.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private MoneyEntity amount;

  /**
   * interaction id.
   */
  @Column(name = "interaction_id")
  private String interactionId;

  /**
   * transaction state.
   */
  @Column
  private TransactionState state;
}
