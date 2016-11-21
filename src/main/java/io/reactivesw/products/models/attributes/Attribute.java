package io.reactivesw.products.models.attributes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class Attribute {

  @ApiModelProperty(value = "Attribute Name", required = true)
  private String name;

  @ApiModelProperty(value = "A valid JSON value, based on an AttributeDefinition.",required = true)
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
    return "Attribute{" +
        "name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
