package io.reactivesw.orders.carts.domain.entities.values;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.utils.MoneyJsonConverter;

/**
 * Created by umasuo on 16/11/17.
 */
@Entity
@Table(name = "orders_carts_taxed_price_value")
public class TaxedPriceValue extends BaseIdEntity {

  /**
   * total net.
   */
  @Column(name = "total_net", nullable = false, columnDefinition = "JSON")
  @Convert(converter = MoneyJsonConverter.class)
  private Money totalNet;

  /**
   * total gross.
   */
  @Column(name = "total_gross", nullable = false, columnDefinition = "JSON")
  @Convert(converter = MoneyJsonConverter.class)
  private Money totalGross;

  /**
   * list of tax portion.
   */
  @OneToMany
  private Set<TaxPortionValue> taxPortions;

  /**
   * to string method.
   * @return
   */
  @Override
  public String toString() {
    return "TaxedPriceValue{" +
            "totalNet=" + totalNet +
            ", totalGross=" + totalGross +
            ", taxPortions=" + taxPortions +
            '}';
  }

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

  /**
   * Gets tax portions.
   *
   * @return the tax portions
   */
  public Set<TaxPortionValue> getTaxPortions() {
    return taxPortions;
  }

  /**
   * Sets tax portions.
   *
   * @param taxPortions the tax portions
   */
  public void setTaxPortions(Set<TaxPortionValue> taxPortions) {
    this.taxPortions = taxPortions;
  }
}
