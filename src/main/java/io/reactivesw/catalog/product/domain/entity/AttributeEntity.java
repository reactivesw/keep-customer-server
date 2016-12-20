package io.reactivesw.catalog.product.domain.entity;

import com.fasterxml.jackson.databind.JsonNode;

import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseIdEntity;

import lombok.Data;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@Entity
@Table(name = "catalog_product_attribute")
@TypeDef(name = "JsonNode", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "com.fasterxml.jackson.databind.JsonNode")}
)
public class AttributeEntity extends BaseIdEntity {

  /**
   * name.
   */
  @Column(name = "name")
  private String name;

  /**
   * Json Object for attribute value.
   */
  @Type(type = "JsonNode")
  private JsonNode value;
}
