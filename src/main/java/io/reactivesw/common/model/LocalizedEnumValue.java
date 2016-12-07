package io.reactivesw.common.model;

/**
 * Created by umasuo on 16/11/18.
 */
public class LocalizedEnumValue {

  /**
   * The key of the value used as a programmatic identifier, e.g. in facets & filters.
   */
  private String key;

  /**
   * A descriptive, localized label of the value.
   */
  private LocalizedString label;

  /**
   * Gets key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets key.
   *
   * @param key the key
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Gets label.
   *
   * @return the label
   */
  public LocalizedString getLabel() {
    return label;
  }

  /**
   * Sets label.
   *
   * @param label the label
   */
  public void setLabel(LocalizedString label) {
    this.label = label;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "LocalizedEnumValue{" +
        "key='" + key + '\'' +
        ", label=" + label +
        '}';
  }
}
