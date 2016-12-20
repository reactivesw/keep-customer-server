package io.reactivesw.catalog.product.application.model.attributes;

import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by umasuo on 16/11/17.
 */
@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {

  @ApiModelProperty(value = "Attribute Name", required = true)
  private String name;

  @ApiModelProperty(value = "A valid JSON value, based on an AttributeDefinitionEntity.", required = true)
  private JsonNode value;
}
