package io.reactivesw.catalog.products.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_variant_attribute")
public class AttributeEntity extends BaseIdEntity {

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

  @Override
  public String toString() {
    return "AttributeEntity{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", value='" + value + '\'' +
            '}';
  }
}
