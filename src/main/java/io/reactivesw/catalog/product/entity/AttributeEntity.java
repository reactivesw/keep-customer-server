package io.reactivesw.catalog.product.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@Entity
@Table(name = "catalog_product_attribute")
public class AttributeEntity extends BaseIdEntity {

  /**
   * name.
   */
  @Column(name = "name")
  private String name;

  /**
   * Json Object for attribute value.
   */
  @Column(name = "value")
  private String value;
}
