package io.reactivesw.project.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by umasuo on 17/1/5.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class International {

  /**
   * default currency.
   */
  private Currency defaultCurrency;

  /**
   * supported currency in this project.
   */
  private List<Currency> supportedCurrencies;

  /**
   * default language.
   */
  private Language defaultLanguage;

  /**
   * support languages.
   */
  private List<Language> supportedLanguages;
}
