package io.reactivesw.merchant.infrastructure.validator;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.merchant.infrastructure.util.LanguageMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Davis on 17/1/9.
 */
public final class LanguageValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(LanguageValidator.class);

  /**
   * Instantiates a new Currency validator.
   */
  private LanguageValidator() {
  }

  /**
   * Validate if currency exist.
   *
   * @param languageCode the language code
   */
  public static void validate(String languageCode) {
    if (!LanguageMap.isLegalLanguage(languageCode)) {
      LOG.debug("can not find language by code : {}", languageCode);
      throw new NotExistException("Language Not Exist");
    }
  }
}
