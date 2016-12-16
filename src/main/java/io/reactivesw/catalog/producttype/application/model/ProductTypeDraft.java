package io.reactivesw.catalog.producttype.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import io.reactivesw.catalog.product.application.model.AttributeDefinitionDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * Created by Davis on 16/11/17.
 */
@Data
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
}
