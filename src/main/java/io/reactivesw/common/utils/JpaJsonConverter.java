package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import io.reactivesw.common.models.LocalizedString;

/**
 * Created by Davis on 16/11/16.
 */
public class JpaJsonConverter implements AttributeConverter<Object, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Object meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public Object convertToEntityAttribute(String dbData) {
    try {

      return objectMapper.readValue(dbData, Object.class);

    } catch (IOException ex) {
      return null;
    }
  }

}
