package io.reactivesw.project.domain.service.update;

import com.google.common.collect.Sets;

import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.application.model.action.SetDefaultLanguageAction;
import io.reactivesw.project.application.model.mapper.LanguageMapper;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.domain.entity.LanguageValue;
import io.reactivesw.project.infrastructure.util.InternationalActionUtils;
import io.reactivesw.project.infrastructure.util.LanguageMap;
import io.reactivesw.project.infrastructure.validator.LanguageValidator;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Davis on 17/1/9.
 */
@Service(value = InternationalActionUtils.SET_DEFAULT_LANGUAGE)
public class SetDefaultLanguageService implements Update<InternationalEntity> {
  /**
   * set default language.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InternationalEntity entity, UpdateAction action) {

    String languageCode = ((SetDefaultLanguageAction) action).getLanguageCode();

    LanguageValidator.validate(languageCode);

    LanguageValue languageValue = LanguageMapper.modelToEntity(
        LanguageMap.getLanguageByCode(languageCode));

    LanguageValue defaultLanguage = entity.getDefaultLanguage();

    Set<LanguageValue> supportedLanguage = entity.getSupportedLanguages();

    if (supportedLanguage == null || supportedLanguage.isEmpty()) {
      supportedLanguage = Sets.newHashSet(languageValue);
    } else {
      supportedLanguage.remove(defaultLanguage);
      supportedLanguage.add(languageValue);
    }
    entity.setDefaultLanguage(languageValue);
    entity.setSupportedLanguages(supportedLanguage);
  }
}
