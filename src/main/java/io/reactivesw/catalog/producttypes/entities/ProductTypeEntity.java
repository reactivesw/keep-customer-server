package io.reactivesw.catalog.producttypes.entities;

import io.reactivesw.common.entities.BaseAllEntity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/22.
 */
@Entity
@Table(name = "catalog_product_type")
public class ProductTypeEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  private Integer version;

  /**
   * key word.
   */
  @Column(name = "product_type_key")
  private String key;

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * description.
   */
  @Column
  private String description;

  /**
   * attributes.
   */
  @OneToMany
  private List<AttributeDefinitionEntity> attributes;

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
  public List<AttributeDefinitionEntity> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(List<AttributeDefinitionEntity> attributes) {
    this.attributes = attributes;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductTypeEntity{"
        + "id=" + id
        + "version=" + version
        + ", key='" + key + '\''
        + ", name='" + name + '\''
        + ", description='" + description + '\''
        + ", attributes=" + attributes
        + '}';
  }
}
