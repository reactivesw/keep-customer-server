package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.common.models.LocalizedString;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Davis on 16/11/16.
 */
public class LocalizedStringConverter implements AttributeConverter<LocalizedString, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(LocalizedString meta) {
    try {
      return objectMapper.writeValueAsString(meta.getLocalized());
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public LocalizedString convertToEntityAttribute(String dbData) {
    try {
      LocalizedString localizedString = new LocalizedString();
      Map<String, String> localized = objectMapper.readValue(dbData, Map.class);
      localizedString.setLocalized(localized);
      return localizedString;
    } catch (IOException ex) {
      return null;
    }
  }

}
