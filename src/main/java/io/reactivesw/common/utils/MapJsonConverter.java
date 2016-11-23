package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.common.models.Money;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Davis on 16/11/23.
 */
public class MapJsonConverter implements AttributeConverter<Map, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Map meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public Map convertToEntityAttribute(String dbData) {
    try {
      Map custom = objectMapper.readValue(dbData, Map.class);
      return custom;
    } catch (IOException ex) {
      return null;
    }
  }

}