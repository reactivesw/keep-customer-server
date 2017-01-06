package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "order_taxed_item_price")
@Data
public class TaxedItemPriceValue extends BaseIdEntity {

  /**
   * total net.
   */
  @OneToOne
  private MoneyEntity totalNet;

  /**
   * total gross.
   */
  @OneToOne
  private MoneyEntity totalGross;

}
