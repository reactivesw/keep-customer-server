package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_tax_portion")
@Data
public class TaxPortionValue extends BaseIdEntity {

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * rate.
   */
  @Column
  private Float rate;

  /**
   * amount of money.
   */
  @OneToOne
  private MoneyEntity amount;
}
