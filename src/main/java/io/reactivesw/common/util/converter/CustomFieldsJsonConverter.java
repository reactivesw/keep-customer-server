package io.reactivesw.common.util.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.reactivesw.common.model.CustomFields;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/16.
 */
public class CustomFieldsJsonConverter implements AttributeConverter<CustomFields, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(CustomFields meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public CustomFields convertToEntityAttribute(String dbData) {
    try {
      CustomFields custom = objectMapper.readValue(dbData, CustomFields.class);
      return custom;
    } catch (IOException ex) {
      return null;
    }
  }

}
