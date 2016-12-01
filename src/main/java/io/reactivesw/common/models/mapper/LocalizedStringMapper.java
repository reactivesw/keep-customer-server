package io.reactivesw.common.models.mapper;

import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.LocalizedString;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Davis on 16/11/30.
 */
public final class LocalizedStringMapper {

  /**
   * Convert to localized string.
   * when localizedStringEntity is null return new LocalizedString.
   *
   * @param localizedStringEntities the localized string entities
   * @return the localized string
   */
  public static LocalizedString convertToLocalizedStringDefaultNew(Set<LocalizedStringEntity>
                                                                       localizedStringEntities) {
    LocalizedString localizedString = new LocalizedString();
    if (localizedStringEntities != null) {
      localizedString = convertToLocalizedString(localizedStringEntities);
    }
    return localizedString;
  }

  /**
   * Convert to localized string.
   * when localizedStringEntity is null return null.
   *
   * @param localizedStringEntities the localized string entities
   * @return the localized string
   */
  public static LocalizedString convertToLocalizedStringDefaultNull(Set<LocalizedStringEntity>
                                                                        localizedStringEntities) {
    LocalizedString localizedString = null;
    if (localizedStringEntities != null) {
      localizedString = convertToLocalizedString(localizedStringEntities);
    }
    return localizedString;
  }

  /**
   * Convert to localized string.
   *
   * @param localizedStringEntities localizedStringEntities
   * @return LocalizedString
   */
  private static LocalizedString convertToLocalizedString(Set<LocalizedStringEntity>
                                                              localizedStringEntities) {
    LocalizedString localizedString = new LocalizedString();
    for (LocalizedStringEntity localizedStringEntity : localizedStringEntities) {
      localizedString.addKeyValue(localizedStringEntity.getLanguage(), localizedStringEntity
          .getText());
    }
    return localizedString;
  }

  /**
   * Convert to Set of LocalizedStringEntity from LocalizedString.
   *
   * @param localizedString the LocalizedString
   * @return Set of LocalizedStringEntity
   */
  public static Set<LocalizedStringEntity> convertToLocalizedStringEntity(LocalizedString
                                                                               localizedString) {
    Set<LocalizedStringEntity> localizedStringEntities = new HashSet<>();

    if (localizedString != null && ! localizedString.getLocalized().isEmpty()) {
      Set<Map.Entry<String, String>> localizeStrings = localizedString.getLocalized().entrySet();
      for (Map.Entry localizedValue : localizeStrings) {
        localizedStringEntities.add(new LocalizedStringEntity(localizedValue.getKey().toString(),
            localizedValue.getValue().toString()));
      }
    }

    return localizedStringEntities;
  }

  public static Set<LocalizedStringEntity> convertToLocalizedStringEntityDefaultNull(LocalizedString
                                                                              localizedString) {
    Set<LocalizedStringEntity> localizedStringEntities = null;

    if (localizedString != null && ! localizedString.getLocalized().isEmpty()) {
      localizedStringEntities = new HashSet<>();
      Set<Map.Entry<String, String>> localizeStrings = localizedString.getLocalized().entrySet();
      for (Map.Entry localizedValue : localizeStrings) {
        localizedStringEntities.add(new LocalizedStringEntity(localizedValue.getKey().toString(),
            localizedValue.getValue().toString()));
      }
    }

    return localizedStringEntities;
  }
}
