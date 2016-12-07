package io.reactivesw.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivesw.common.model.Money;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Davis on 16/11/23.
 */
public class MoneyJsonConverter implements AttributeConverter<Money, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Money meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public Money convertToEntityAttribute(String dbData) {
    try {
      Money custom = objectMapper.readValue(dbData, Money.class);
      return custom;
    } catch (IOException ex) {
      return null;
    }
  }

}