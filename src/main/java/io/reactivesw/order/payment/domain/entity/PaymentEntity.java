package io.reactivesw.order.payment.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.payment.domain.entity.value.PaymentMethodInfoValue;
import io.reactivesw.order.payment.domain.entity.value.PaymentStatusValue;
import io.reactivesw.order.payment.domain.entity.value.TransactionValue;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by Davis on 17/2/4.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order_payment")
public class PaymentEntity extends BaseAllEntity{
  /**
   * version.
   */
  @Version
  @Column(name = "version")
  private Integer version;

  /**
   * The Customer id.
   */
  @Column(name = "customer_id", nullable = false)
  private String customerId;

  /**
   * The External id.
   */
  @Column(name = "external_id")
  private String externalId;

  /**
   * The Interface id.
   */
  @Column(name = "interface_Id")
  private String interfaceId;

  /**
   * The Amount planned.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private MoneyEntity amountPlanned;

  /**
   * The Amount authorized.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private MoneyEntity amountAuthorized;

  /**
   * The Authorized until.
   */
  @Column(name = "authorized_until")
  private String authorizedUntil;

  /**
   * The Amount paid.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private MoneyEntity amountPaid;

  /**
   * The Amount refunded.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private MoneyEntity amountRefunded;

  /**
   * payment method info.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private PaymentMethodInfoValue paymentMethodInfo;

  /**
   * The Payment status value.
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private PaymentStatusValue paymentStatus;

  /**
   * the transaction list.
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<TransactionValue> transactions;

}
