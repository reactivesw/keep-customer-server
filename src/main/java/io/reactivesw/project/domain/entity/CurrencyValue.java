package io.reactivesw.project.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 17/1/5.
 */
@Entity
@Table(name = "project_currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"currencyCode", "conversionFactor", "name"})
public class CurrencyValue extends BaseIdEntity {

  /**
   * currency code.
   */
  @Column
  private String currencyCode;

  /**
   * conversion factor.
   */
  @Column
  private String conversionFactor;

  /**
   * name.
   */
  @Column
  private String name;
}
