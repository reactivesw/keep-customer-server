package io.reactivesw.order.payment.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 17/2/4.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order_payment_status")
public class PaymentStatusValue extends BaseIdEntity {
  /**
   * interface code.
   */
  @Column(name = "interface_code")
  private String interfaceCode;

  /**
   * interface text.
   */
  @Column(name = "interface_text")
  private String interfaceText;

  /**
   * reference to state.
   */
  @Column(name = "state_id")
  private String stateId;
}
