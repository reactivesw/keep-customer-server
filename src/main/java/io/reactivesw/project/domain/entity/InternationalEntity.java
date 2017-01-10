package io.reactivesw.project.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 17/1/5.
 */
@Entity
@Table(name = "project_international")
@Data
@EqualsAndHashCode(callSuper = false)
public class InternationalEntity extends BaseAllEntity {

  /**
   * default currency.
   */
  @OneToOne
  private CurrencyValue defaultCurrency;

  /**
   * supported currency.
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<CurrencyValue> supportedCurrency;

  /**
   * default language.
   */
  @OneToOne
  private LanguageValue defaultLanguage;

  /**
   * supported language.
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<LanguageValue> supportedLanguage;
}
