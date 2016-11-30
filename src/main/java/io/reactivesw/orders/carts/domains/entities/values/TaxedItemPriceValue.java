package io.reactivesw.orders.carts.domains.entities.values;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.entities.MoneyEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "orders_carts_taxed_item_price_value")
public class TaxedItemPriceValue  extends BaseIdEntity {

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

  /**
   * Gets total net.
   *
   * @return the total net
   */
  public MoneyEntity getTotalNet() {
    return totalNet;
  }

  /**
   * Sets total net.
   *
   * @param totalNet the total net
   */
  public void setTotalNet(MoneyEntity totalNet) {
    this.totalNet = totalNet;
  }

  /**
   * Gets total gross.
   *
   * @return the total gross
   */
  public MoneyEntity getTotalGross() {
    return totalGross;
  }

  /**
   * Sets total gross.
   *
   * @param totalGross the total gross
   */
  public void setTotalGross(MoneyEntity totalGross) {
    this.totalGross = totalGross;
  }

  /**
   * to string method.
   * @return String
   */
  @Override
  public String toString() {
    return "TaxedItemPriceValue{"
        + "totalNet=" + totalNet
        + ", totalGross=" + totalGross
        + '}';
  }
}
