package io.reactivesw.catalog.producttype.domain.entity;

import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint;
import io.reactivesw.catalog.product.application.model.attributes.AttributeType;
import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.TextInputHint;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@Data
@EqualsAndHashCode
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
}
