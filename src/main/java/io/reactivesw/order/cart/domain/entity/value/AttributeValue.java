package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "order_cart_variant_attribute")
public class AttributeValue extends BaseIdEntity {

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
   * to string method.
   * @return String
   */
  @Override
  public String toString() {
    return "AttributeValue{"
        + "name='" + name + '\''
        + ", value='" + value + '\''
        + '}';
  }
}
