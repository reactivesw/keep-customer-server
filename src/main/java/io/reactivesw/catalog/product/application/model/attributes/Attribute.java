package io.reactivesw.catalog.product.application.model.attributes;

import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class Attribute {

  @ApiModelProperty(value = "Attribute Name", required = true)
  private String name;

  @ApiModelProperty(value = "A valid JSON value, based on an AttributeDefinitionEntity.", required = true)
  private JsonNode value;

  public Attribute() {
  }

  public String getName() {
    return name;
  }

  public JsonNode getValue() {
    return value;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setValue(JsonNode value) {
    this.value = value;
  }
}
