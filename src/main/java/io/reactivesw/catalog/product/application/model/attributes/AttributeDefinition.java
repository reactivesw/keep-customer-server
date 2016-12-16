package io.reactivesw.catalog.product.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.reactivesw.common.model.TextInputHint;
import io.reactivesw.common.model.LocalizedString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * Created by Davis on 16/11/16.
 */
@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttributeDefinition {

  /**
   * Describes the type of the attribute.
   */
  @ApiModelProperty(required = true)
  private AttributeType type;

  /**
   * he unique name of the attribute used in the API.
   * The name must be between two and 36 characters long
   * and can contain the ASCII letters A to Z in lowercase or uppercase, digits, underscores (_)
   * and the hyphen-minus (-).
   * It is allowed to have attributes with the same name in two or more productTypes.
   * The important constraint is:
   * all fields of the AttributeDefinitionEntity need to
   * be the same across all attributes with the same name.
   */
  @ApiModelProperty(required = true)
  private String name;

  /**
   * A human-readable label for the attribute.
   */
  private LocalizedString label;

  /**
   * Additional information about the attribute that aids content managers
   * when setting product details.
   */
  @ApiModelProperty(required = false)
  private LocalizedString inputTip;

  /**
   * Whether the attribute is required to have a value.
   */
  @ApiModelProperty(required = true)
  private Boolean isRequired;

  /**
   * Describes how an attribute or a set of attributes
   * should be validated across all variants of a product.
   */
  @ApiModelProperty(required = true)
  private AttributeConstraint attributeConstraint;

  /**
   * Provides a visual representation type for this attribute.
   * only relevant for text-based attribute model like TextType and LocalizableTextType.
   */
  @ApiModelProperty(required = false)
  private TextInputHint inputHint;

  /**
   * Whether the attribute’s value should generally be enabled in product search.
   * This determines whether the value is stored in product for matching terms in the context of
   * full-text search query and can be used in facets &
   * filters as part of product search query.
   * The exact features that are enabled/disabled with this flag
   * depend on the concrete attribute type and are described there.
   * The max size of a searchable field is restricted to 10922 characters.
   * This constraint is enforced at both product creation and product update.
   * If the length of the input exceeds the maximum size an InvalidField error is returned.
   */
  @ApiModelProperty(required = false)
  private Boolean isSearchable;
}
