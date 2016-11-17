package io.reactivesw.customer.server.common.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Davis on 16/11/16.
 */
@JsonSerialize
public class LocalizedString {
  /**
   * Object Mapper.
   */
  private final static ObjectMapper objectMapper = new ObjectMapper();

  /**
   * The Localized.
   */
  private Map<String, String> localized;

  /**
   * private contructor.
   */
  public LocalizedString() {
    if (localized == null) {
      localized = new HashMap<>();
    }
  }

  /**
   * Gets localized.
   *
   * @return the localized
   */
  public Map<String, String> getLocalized() {
    return localized;
  }

  /**
   * Sets localized.
   *
   * @param localized the localized
   */
  public void setLocalized(Map<String, String> localized) {
    this.localized = localized;
  }

  /**
   * Get localized string string.
   *
   * @return the string
   */
  public String getLocalizedString() {
    String result = "";
    try {
      result = objectMapper.writeValueAsString(localized);
    } catch (JsonProcessingException ex) {
      result = null;
    }
    return result;
  }

  /**
   * Add key value string.
   *
   * @param key   the key
   * @param value the value
   * @return the string
   */
  public String addKeyValue(String key, String value) {
    localized.put(key, value);
    return getLocalizedString();
  }

  /**
   * Clear.
   */
  public void clear() {
    localized.clear();
  }
}
