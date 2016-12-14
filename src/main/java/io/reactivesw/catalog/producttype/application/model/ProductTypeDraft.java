package io.reactivesw.catalog.producttype.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import io.reactivesw.catalog.product.application.model.AttributeDefinitionDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Davis on 16/11/17.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeDraft {
  /**
   * The Name.
   */
  @ApiModelProperty(required = true)
  private String name;

  /**
   * The Key.
   */
  @ApiModelProperty(required = false)
  private String key;

  /**
   * The Description.
   */
  @ApiModelProperty(required = true)
  private String description;

  /**
   * The Attributes.
   */
  @ApiModelProperty(required = false)
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
