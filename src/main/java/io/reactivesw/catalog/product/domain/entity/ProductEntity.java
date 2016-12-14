package io.reactivesw.catalog.product.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by umasuo on 16/11/23.
 */
@Data
@Entity
@Table(name = "catalog_product")
public class ProductEntity extends BaseAllEntity {

  /**
   * key value.
   */
  @Column(name = "key_value")
  private String key;

  /**
   * version.
   */
  @Version
  @Column
  private Integer version;

  /**
   * product type id.
   */
  @Column(name = "product_type_id")
  private String productType;

  /**
   * master data.
   */
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ProductCatalogDataEntity masterData;

  /**
   * tax category id.
   */
  @Column(name = "tax_category_id")
  private String taxCategory;

  /**
   * state id.
   */
  @Column(name = "state_id")
  private String state;
}
