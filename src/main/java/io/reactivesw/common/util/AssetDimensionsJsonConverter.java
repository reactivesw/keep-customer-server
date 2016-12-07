package io.reactivesw.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.common.model.AssetDimensions;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/23.
 */
public class AssetDimensionsJsonConverter implements AttributeConverter<AssetDimensions, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(AssetDimensions meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public AssetDimensions convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, AssetDimensions.class);
    } catch (IOException ex) {
      return null;
    }
  }

}