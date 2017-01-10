package io.reactivesw.project.domain.service.update;

import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.application.model.action.RemoveSupportLanguageAction;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.domain.entity.LanguageValue;
import io.reactivesw.project.infrastructure.util.InternationalActionUtils;
import io.reactivesw.project.infrastructure.validator.LanguageValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by Davis on 17/1/9.
 */
@Service(value = InternationalActionUtils.REMOVE_SUPPORT_LANGUAGE)
public class RemoveSupportLanguageService implements Update<InternationalEntity> {

  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RemoveSupportLanguageService.class);

  /**
   * add support language.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InternationalEntity entity, UpdateAction action) {

    String languageCode = ((RemoveSupportLanguageAction) action).getLanguageCode();

    LanguageValidator.validate(languageCode);

    if (entity.getDefaultLanguage().getLanguageCode().equals(languageCode)) {
      LOG.debug("can not remove support language which is default language, code is : {}",
          languageCode);
      throw new ParametersException("Can not remove support language which is default language.");
    }

    Set<LanguageValue> supportedLanguage = entity.getSupportedLanguages();

    Predicate<LanguageValue> predicate = languageValue -> languageValue
        .getLanguageCode().equals(languageCode);

    supportedLanguage.removeIf(predicate);

    entity.setSupportedLanguages(supportedLanguage);
  }
}
