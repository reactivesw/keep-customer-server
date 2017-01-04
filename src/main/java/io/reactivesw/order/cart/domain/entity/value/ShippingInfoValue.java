package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "order_cart_shipping_info")
@Data
public class ShippingInfoValue extends BaseIdEntity {


  /**
   * shipping method.
   */
  @Column(name = "shipping_method_id")
  private String shippingMethod;

}
