package io.reactivesw.customer.server.common.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Davis on 16/11/16.
 */
public class LocalizedString {

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
   * Add key value string.
   *
   * @param key   the key
   * @param value the value
   * @return the string
   */
  public void addKeyValue(String key, String value) {
    localized.put(key, value);
  }

  /**
   * Clear.
   */
  public void clear() {
    localized.clear();
  }
}
