package io.reactivesw.project.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by umasuo on 17/1/5.
 */
@Entity
@Table(name = "project_currency")
@Data
@EqualsAndHashCode(callSuper = false)
public class CurrencyValue extends BaseIdEntity {

  /**
   * currency code.
   */
  @Column
  private String currencyCode;

  /**
   * name.
   */
  @Column
  private String name;
}
