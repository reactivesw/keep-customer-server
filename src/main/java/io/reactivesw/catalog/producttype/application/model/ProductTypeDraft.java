package io.reactivesw.catalog.producttype.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import io.reactivesw.catalog.product.application.model.AttributeDefinitionDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
  @NotNull(message = "product type name can not be null")
  private String name;

  /**
   * The Key.
   */
  @ApiModelProperty(required = false)
  @Size(max = 256, message = "product type key should less than 256 characters")
  private String key;

  /**
   * The Description.
   */
  @ApiModelProperty(required = true)
  @NotNull(message = "description can not be null")
  private String description;

  /**
   * The Attributes.
   */
  @ApiModelProperty(required = false)
  @Valid
  private List<AttributeDefinitionDraft> attributes;
}
