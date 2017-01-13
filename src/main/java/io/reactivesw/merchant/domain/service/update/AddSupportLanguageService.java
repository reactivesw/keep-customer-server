package io.reactivesw.merchant.domain.service.update;

import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.merchant.application.model.action.AddSupportLanguageAction;
import io.reactivesw.merchant.application.model.mapper.LanguageMapper;
import io.reactivesw.merchant.domain.entity.InternationalEntity;
import io.reactivesw.merchant.domain.entity.LanguageValue;
import io.reactivesw.merchant.infrastructure.util.InternationalActionUtils;
import io.reactivesw.merchant.infrastructure.util.LanguageMap;
import io.reactivesw.merchant.infrastructure.validator.LanguageValidator;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Davis on 17/1/9.
 */
@Service(value = InternationalActionUtils.ADD_SUPPORTED_LANGUAGE)
public class AddSupportLanguageService implements Update<InternationalEntity> {

  /**
   * add support currency.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InternationalEntity entity, UpdateAction action) {

    String languageCode = ((AddSupportLanguageAction) action).getLanguageCode();

    LanguageValidator.validate(languageCode);

    LanguageValue languageValue = LanguageMapper.modelToEntity(
        LanguageMap.getLanguageByCode(languageCode));

    Set<LanguageValue> supportedLanguage = entity.getSupportedLanguages();
    supportedLanguage.add(languageValue);

    entity.setSupportedLanguages(supportedLanguage);
  }
}
