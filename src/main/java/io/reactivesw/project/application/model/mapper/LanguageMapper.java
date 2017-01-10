package io.reactivesw.project.application.model.mapper;

import io.reactivesw.project.application.model.Language;
import io.reactivesw.project.domain.entity.LanguageValue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

  public static List<Language> entityToModel(Set<LanguageValue> entities) {
    return entities.parallelStream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }

  public static Language entityToModel(LanguageValue entity) {
    Language model = new Language();

    model.setNativeName(entity.getNativeName());
    model.setLanguageCode(entity.getLanguageCode());
    model.setName(entity.getName());

    return model;
  }
}
