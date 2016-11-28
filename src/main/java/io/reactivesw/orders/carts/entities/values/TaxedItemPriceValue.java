package io.reactivesw.orders.carts.entities.values;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.reactivesw.common.models.Statics;
import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.utils.MoneyJsonConverter;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "orders_carts_taxed_item_price_value")
public class TaxedItemPriceValue  extends BaseIdEntity {

  /**
   * total net.
   */
  @Column(name = "total_net", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = MoneyJsonConverter.class)
  private Money totalNet;

  /**
   * tatal gross.
   */
  @Column(name = "total_gross", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = MoneyJsonConverter.class)
  private Money totalGross;

  /**
   * Gets total net.
   *
   * @return the total net
   */
  public Money getTotalNet() {
    return totalNet;
  }

  /**
   * Sets total net.
   *
   * @param totalNet the total net
   */
  public void setTotalNet(Money totalNet) {
    this.totalNet = totalNet;
  }

  /**
   * Gets total gross.
   *
   * @return the total gross
   */
  public Money getTotalGross() {
    return totalGross;
  }

  /**
   * Sets total gross.
   *
   * @param totalGross the total gross
   */
  public void setTotalGross(Money totalGross) {
    this.totalGross = totalGross;
  }
}
