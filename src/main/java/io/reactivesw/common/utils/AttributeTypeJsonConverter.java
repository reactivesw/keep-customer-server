package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.catalog.products.models.attributes.AttributeType;
import io.reactivesw.common.models.CustomFields;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/22.
 */
public class AttributeTypeJsonConverter implements AttributeConverter<AttributeType, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(AttributeType meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public AttributeType convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, AttributeType.class);
    } catch (IOException ex) {
      return null;
    }
  }

}