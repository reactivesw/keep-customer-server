package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import io.reactivesw.common.models.LocalizedString;

/**
 * Created by Davis on 16/11/16.
 */
public class LocalizedStringJsonConverter implements AttributeConverter<LocalizedString, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(LocalizedString meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      //TODO throws the exceptions
      return null;
    }
  }

  @Override
  public LocalizedString convertToEntityAttribute(String dbData) {
    try {
      LocalizedString string = objectMapper.readValue(dbData, LocalizedString.class);
      return string;
    } catch (IOException ex) {
      //TODO throws the exceptions
      return null;
    }
  }

}
