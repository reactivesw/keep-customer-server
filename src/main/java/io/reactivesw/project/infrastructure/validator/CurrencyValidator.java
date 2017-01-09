package io.reactivesw.project.infrastructure.validator;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.project.infrastructure.util.CurrencyMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Davis on 17/1/9.
 */
public final class CurrencyValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CurrencyValidator.class);

  /**
   * Instantiates a new Currency validator.
   */
  private CurrencyValidator() {
  }

  /**
   * Validate if currency exist.
   *
   * @param currencyCode the currency code
   */
  public static void validate(String currencyCode) {
    if (!CurrencyMap.isLegalCurrency(currencyCode)) {
      LOG.debug("can not find currency by code : {}", currencyCode);
      throw new NotExistException("Currency Not Exist");
    }
  }
}
