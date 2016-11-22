package io.reactivesw.catalog.producttypes.models.entities;

import io.reactivesw.catalog.products.models.attributes.AttributeConstraint;
import io.reactivesw.catalog.products.models.attributes.AttributeType;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.TextInputHint;

/**
 * Created by Davis on 16/11/22.
 */
public class AttributeDefinitionEntity {
  private AttributeType type;

  private String name;

  private LocalizedString label;

  private LocalizedString inputTip;

  private Boolean isRequired;

  private AttributeConstraint attributeConstraint;

  private TextInputHint inputHint;

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
}
