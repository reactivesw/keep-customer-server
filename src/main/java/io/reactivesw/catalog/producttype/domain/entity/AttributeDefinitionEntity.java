package io.reactivesw.catalog.producttype.domain.entity;

import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeType;
import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.TextInputHint;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/22.
 */
@Entity
@Table(name = "catalog_product_type_attribute_definition")
@TypeDef(name = "attributeType", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS,
        value = "io.reactivesw.catalog.product.application.model.attributes.AttributeType")}
)
public class AttributeDefinitionEntity extends BaseAllEntity {

  /**
   * The Type.
   */
  @Type(type = "attributeType")
  private AttributeType type;

  /**
   * The Name.
   */
  @Column
  private String name;

  /**
   * The Label.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> label;

  /**
   * The Input tip.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> inputTip;

  /**
   * The Is required.
   */
  @Column
  private Boolean required;

  /**
   * The Attribute constraint.
   */
  @Column
  private AttributeConstraint attributeConstraint;

  /**
   * The Input hint.
   */
  @Column
  private TextInputHint inputHint;

  /**
   * The Is searchable.
   */
  @Column
  private Boolean searchable;

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
  public Set<LocalizedStringEntity> getLabel() {
    return label;
  }

  /**
   * Sets label.
   *
   * @param label the label
   */
  public void setLabel(Set<LocalizedStringEntity> label) {
    this.label = label;
  }

  /**
   * Gets input tip.
   *
   * @return the input tip
   */
  public Set<LocalizedStringEntity> getInputTip() {
    return inputTip;
  }

  /**
   * Sets input tip.
   *
   * @param inputTip the input tip
   */
  public void setInputTip(Set<LocalizedStringEntity> inputTip) {
    this.inputTip = inputTip;
  }

  /**
   * Gets required.
   *
   * @return the required
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * Sets required.
   *
   * @param required the required
   */
  public void setRequired(Boolean required) {
    this.required = required;
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
    return searchable;
  }

  /**
   * Sets searchable.
   *
   * @param searchable the searchable
   */
  public void setSearchable(Boolean searchable) {
    this.searchable = searchable;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "AttributeDefinitionEntity{"
        + "type=" + type
        + ", name='" + name + '\''
        + ", label=" + label
        + ", inputTip=" + inputTip
        + ", required=" + required
        + ", attributeConstraint=" + attributeConstraint
        + ", inputHint=" + inputHint
        + ", searchable=" + searchable
        + '}';
  }
}
