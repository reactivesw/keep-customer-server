package io.reactivesw.customer.server.catalog.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Davis on 16/11/16.
 */
//@Entity
//@Table(name = "sw_product_type")
public class ProductType {
  /**
   * The Id.
   */
  private String id;
  /**
   * The Version.
   */
  private Integer version;
  /**
   * The Created at.
   */
  private ZonedDateTime createdAt;
  /**
   * The Last modified at.
   */
  private ZonedDateTime lastModifiedAt;
  /**
   * The Key.
   */
  private String key;
  /**
   * The Name.
   */
  private String name;
  /**
   * The Description.
   */
  private String description;
  /**
   * The Attributes.
   */
  private Set<AttributeDefinition> attributes;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets last modified at.
   *
   * @return the last modified at
   */
  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Sets last modified at.
   *
   * @param lastModifiedAt the last modified at
   */
  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
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
  public Set<AttributeDefinition> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(Set<AttributeDefinition> attributes) {
    this.attributes = attributes;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductType{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", key='" + key + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", attributes=" + attributes +
        '}';
  }
}
