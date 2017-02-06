package io.reactivesw.order.payment.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 17/2/4.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order_payment_method_info")
public class PaymentMethodInfoValue extends BaseIdEntity{
  /**
   * payment interface.
   */
  @Column(name = "payment_interface")
  private String paymentInterface;

  /**
   * method.
   */
  @Column(name = "method")
  private String method;

  /**
   * name.
   */
  /**
   * The Name.
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> name;
}
