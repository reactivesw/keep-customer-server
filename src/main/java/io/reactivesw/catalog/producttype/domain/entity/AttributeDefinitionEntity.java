package io.reactivesw.catalog.producttype.domain.entity;

import io.reactivesw.catalog.product.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.model.attributes.AttributeType;
import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.TextInputHint;
import io.reactivesw.common.util.AttributeTypeJsonConverter;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/22.
 */
@Entity
@Table(name = "catalog_product_type_attribute_definition")
public class AttributeDefinitionEntity extends BaseAllEntity {

  /**
   * The Type.
   */
  @Column(name = "type", nullable = false, columnDefinition = "JSON")
  @Convert(converter = AttributeTypeJsonConverter.class)
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
