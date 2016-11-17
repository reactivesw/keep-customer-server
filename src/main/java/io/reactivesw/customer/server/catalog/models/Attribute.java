package io.reactivesw.customer.server.catalog.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class Attribute {

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(value = "A valid JSON value, based on an AttributeDefinition.",required = true)
  private String value;
}
