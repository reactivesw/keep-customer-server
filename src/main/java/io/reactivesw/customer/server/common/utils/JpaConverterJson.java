package io.reactivesw.customer.server.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.customer.server.common.types.LocalizedString;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Davis on 16/11/16.
 */
public class JpaConverterJson implements AttributeConverter<LocalizedString, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(LocalizedString meta) {
    try {
//      return objectMapper.writeValueAsString(meta.getLocalized());
      return objectMapper.writeValueAsString(meta);

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
//      return objectMapper.readValue(dbData, Object.class);
    } catch (IOException ex) {
      // logger.error("Unexpected IOEx decoding json from database: " + dbData);
      return null;
    }
  }

}
