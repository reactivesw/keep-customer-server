package io.reactivesw.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.reactivesw.common.models.TextInputHint;
import io.reactivesw.common.models.LocalizedString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Davis on 16/11/16.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeDefinition {

  /**
   * Describes the type of the attribute. TODO
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
   * all fields of the AttributeDefinition need to
   * be the same across all attributes with the same name.
   */
  @ApiModelProperty(required = true)
  private String name;

  /**
   * A human-readable label for the attribute.
   */
  @JsonIgnore
  private LocalizedString label;

  /**
   * Additional information about the attribute that aids content managers
   * when setting product details.
   */
  @JsonIgnore
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
   * only relevant for text-based attribute models like TextType and LocalizableTextType.
   */
  //TODO String should be TextInputHint
  @ApiModelProperty(required = false)
  private TextInputHint inputHint;

  /**
   * Whether the attribute’s values should generally be enabled in product search.
   * This determines whether the value is stored in products for matching terms in the context of
   * full-text search queries and can be used in facets &
   * filters as part of product search queries.
   * The exact features that are enabled/disabled with this flag
   * depend on the concrete attribute type and are described there.
   * The max size of a searchable field is restricted to 10922 characters.
   * This constraint is enforced at both product creation and product update.
   * If the length of the input exceeds the maximum size an InvalidField error is returned.
   */
  @ApiModelProperty(required = false)
  private Boolean isSearchable;

  /**
   * Gets type.
   *
   * @return the type
   */
  public AttributeType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(AttributeType type) {
    this.type = type;
  }

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
   * Gets label.
   *
   * @return the label
   */
  public LocalizedString getLabel() {
    return label;
  }

  /**
   * Sets label.
   *
   * @param label the label
   */
  public void setLabel(LocalizedString label) {
    this.label = label;
  }

  /**
   * Gets input tip.
   *
   * @return the input tip
   */
  public LocalizedString getInputTip() {
    return inputTip;
  }

  /**
   * Sets input tip.
   *
   * @param inputTip the input tip
   */
  public void setInputTip(LocalizedString inputTip) {
    this.inputTip = inputTip;
  }

  /**
   * Gets required.
   *
   * @return the required
   */
  public Boolean getRequired() {
    return isRequired;
  }

  /**
   * Sets required.
   *
   * @param required the required
   */
  public void setRequired(Boolean required) {
    isRequired = required;
  }

  /**
   * Gets attribute constraint.
   *
   * @return the attribute constraint
   */
  public AttributeConstraint getAttributeConstraint() {
    return attributeConstraint;
  }

  /**
   * Sets attribute constraint.
   *
   * @param attributeConstraint the attribute constraint
   */
  public void setAttributeConstraint(AttributeConstraint attributeConstraint) {
    this.attributeConstraint = attributeConstraint;
  }

  /**
   * Gets input hint.
   *
   * @return the input hint
   */
  public TextInputHint getInputHint() {
    return inputHint;
  }

  /**
   * Sets input hint.
   *
   * @param inputHint the input hint
   */
  public void setInputHint(TextInputHint inputHint) {
    this.inputHint = inputHint;
  }

  /**
   * Gets searchable.
   *
   * @return the searchable
   */
  public Boolean getSearchable() {
    return isSearchable;
  }

  /**
   * Sets searchable.
   *
   * @param searchable the searchable
   */
  public void setSearchable(Boolean searchable) {
    isSearchable = searchable;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "AttributeDefinition{" +
            "type=" + type +
            ", name='" + name + '\'' +
            ", label=" + label +
            ", inputTip=" + inputTip +
            ", isRequired=" + isRequired +
            ", attributeConstraint=" + attributeConstraint +
            ", inputHint='" + inputHint + '\'' +
            ", isSearchable=" + isSearchable +
            '}';
  }
}
