package io.reactivesw.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
  @JsonSerialize
  private JsonNode value;


  @JsonCreator
  public Attribute(final String name, final JsonNode value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public JsonNode getValue() {
    return value;
  }
}
