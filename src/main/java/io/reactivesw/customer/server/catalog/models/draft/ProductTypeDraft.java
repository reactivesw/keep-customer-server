package io.reactivesw.customer.server.catalog.models.draft;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductTypeDraft {
  /**
   * The Name.
   */
  private String name;
  /**
   * The Key.
   */
  private String key;
  /**
   * The Description.
   */
  private String description;
  /**
   * The Attributes.
   */
  private List<AttributeDefinitionDraft> attributes;

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

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
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets attributes.
   *
   * @return the attributes
   */
  public List<AttributeDefinitionDraft> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(List<AttributeDefinitionDraft> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "ProductTypeDraft{" +
        "name='" + name + '\'' +
        ", key='" + key + '\'' +
        ", description='" + description + '\'' +
        ", attributes=" + attributes +
        '}';
  }
}
