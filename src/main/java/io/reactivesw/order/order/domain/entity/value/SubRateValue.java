package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_cart_sub_rate")
@Data
public class SubRateValue extends BaseIdEntity {

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * amount.
   */
  @Column
  private Float amount;
}
