package io.reactivesw.catalog.product.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "catalog_product_attribute")
public class AttributeEntity extends BaseIdEntity {

  /**
   * name.
   */
  @Column(name = "name")
  private String name;

  /**
   * Json Object for attribute value.
   */
  @Column(name = "value")
  private String value;

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
   * Gets value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "AttributeEntity{"
        + "name='" + name + '\''
        + ", value='" + value + '\''
        + '}';
  }
}
