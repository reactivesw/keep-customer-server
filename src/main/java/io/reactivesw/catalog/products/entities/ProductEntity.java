package io.reactivesw.catalog.products.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseAllEntity;

/**
 * Created by umasuo on 16/11/23.
 */
@Table(name = "catalog_product")
@Entity
public class ProductEntity extends BaseAllEntity {

  @Column
  private String keyValue;

  @Column
  private Integer version;

  /**
   * product type id.
   */
  @Column(name = "product_type")
  private String productType;

  @OneToOne
  private ProductCatalogDataEntity masterData;

  /**
   * tax category id.
   */
  @Column(name = "tax_category")
  private String taxCategory;

  /**
   * state id.
   */
  @Column(name = "state")
  private String state;
}
