package io.reactivesw.catalog.producttype.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by Davis on 16/11/22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "catalog_product_type")
public class ProductTypeEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Version
  @Column
  private Integer version;

  /**
   * key word.
   */
  @Column(name = "product_type_key")
  private String key;

  /**
   * name.
   */
  @Column
  private String name;

  /**
   * description.
   */
  @Column
  private String description;

  /**
   * attributes.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<AttributeDefinitionEntity> attributes;
}
