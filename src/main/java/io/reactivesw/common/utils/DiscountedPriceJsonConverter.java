package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.catalog.productdiscounts.models.DiscountedPrice;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/23.
 */
public class DiscountedPriceJsonConverter implements AttributeConverter<DiscountedPrice, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(DiscountedPrice meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public DiscountedPrice convertToEntityAttribute(String dbData) {
    try {
      DiscountedPrice custom = objectMapper.readValue(dbData, DiscountedPrice.class);
      return custom;
    } catch (IOException ex) {
      return null;
    }
  }

}