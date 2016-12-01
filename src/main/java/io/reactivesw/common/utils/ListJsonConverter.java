package io.reactivesw.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.AttributeConverter;

import io.reactivesw.common.models.LocalizedString;

/**
 * Created by Davis on 16/11/16.
 */
public class ListJsonConverter implements AttributeConverter<ArrayList, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(ArrayList meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (Exception ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public ArrayList<String> convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, ArrayList.class);
    } catch (IOException ex) {
      return null;
    }
  }

}
