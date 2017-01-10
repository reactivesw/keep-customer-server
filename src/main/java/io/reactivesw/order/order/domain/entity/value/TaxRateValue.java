package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/17.
 * //TODO should we keep this in snapshot?
 */
@Entity
@Table(name = "order_tax_rate")
@Data
@EqualsAndHashCode(callSuper = false)
public class TaxRateValue extends BaseIdEntity {

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

  /**
   * if included in price.
   */
  @Column
  private Boolean includedInPrice;

  /**
   * country.
   */
  @Column
  private String country;

  /**
   * state.
   */
  @Column
  private String state;

  /**
   * list of sub rate.
   */
  @OneToMany
  private Set<SubRateValue> subRates;
}
