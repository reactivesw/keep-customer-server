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
@Table(name = "order_cart_line_item")
@Data
public class LineItemValue extends BaseIdEntity {

  /**
   * product id.
   */
  @Column(name = "product_id")
  private String productId;

  /**
   * product variant.
   * a snap shop for variant.
   */
  @Column(name = "variant_id")
  private Integer variant;

  /**
   * quantity.
   */
  @Column
  private Integer quantity;

  /**
   * supplyChannel.
   */
  @Column(name = "supply_channel")
  private String supplyChannel;

  /**
   * distributionChannel.
   */
  @Column(name = "distribution_channel")
  private String distributionChannel;


}
