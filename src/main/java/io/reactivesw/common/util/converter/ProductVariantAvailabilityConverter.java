package io.reactivesw.common.util.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.catalog.product.application.model.ProductVariantAvailability;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/23.
 */
public class ProductVariantAvailabilityConverter implements AttributeConverter<ProductVariantAvailability, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(ProductVariantAvailability meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public ProductVariantAvailability convertToEntityAttribute(String dbData) {
    try {
      ProductVariantAvailability custom = objectMapper.readValue(dbData, ProductVariantAvailability.class);
      return custom;
    } catch (IOException ex) {
      return null;
    }
  }

}