package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_cart_shipping_rate")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShippingRateValue extends BaseIdEntity {

  /**
   * price in money.
   */
  @OneToOne
  private MoneyEntity price;

  /**
   * free above in money.
   */
  @OneToOne
  private MoneyEntity freeAbove;
}
