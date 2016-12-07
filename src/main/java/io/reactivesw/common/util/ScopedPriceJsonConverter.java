package io.reactivesw.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.catalog.product.model.ScopedPrice;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/23.
 */
public class ScopedPriceJsonConverter implements AttributeConverter<ScopedPrice, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(ScopedPrice meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public ScopedPrice convertToEntityAttribute(String dbData) {
    try {
      ScopedPrice custom = objectMapper.readValue(dbData, ScopedPrice.class);
      return custom;
    } catch (IOException ex) {
      return null;
    }
  }

}
