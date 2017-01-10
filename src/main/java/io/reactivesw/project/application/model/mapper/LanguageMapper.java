package io.reactivesw.project.application.model.mapper;

import io.reactivesw.project.application.model.Language;
import io.reactivesw.project.domain.entity.LanguageValue;

/**
 * Created by Davis on 17/1/10.
 */
public final class LanguageMapper {
  /**
   * Instantiates a new Language mapper.
   */
  private LanguageMapper() {
  }

  /**
   * Model to enity language value.
   *
   * @param model the model
   * @return the language value
   */
  public static LanguageValue modelToEntity(Language model) {
    LanguageValue entity = new LanguageValue();

    entity.setName(model.getName());
    entity.setLanguageCode(model.getLanguageCode());
    entity.setNativeName(model.getNativeName());

    return entity;
  }
}
