package io.reactivesw.catalog.products.entities;

import io.reactivesw.common.entities.BaseAllEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/23.
 */
@Table(name = "catalog_product")
@Entity
public class ProductEntity extends BaseAllEntity {

  /**
   * key value.
   */
  @Column
  private String keyValue;

  /**
   * version.
   */
  @Column
  private Integer version;

  /**
   * product type id.
   */
  @Column(name = "product_type")
  private String productType;

  /**
   * master data.
   */
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

  /**
   * Gets key value.
   *
   * @return the key value
   */
  public String getKeyValue() {
    return keyValue;
  }

  /**
   * Sets key value.
   *
   * @param keyValue the key value
   */
  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets product type.
   *
   * @return the product type
   */
  public String getProductType() {
    return productType;
  }

  /**
   * Sets product type.
   *
   * @param productType the product type
   */
  public void setProductType(String productType) {
    this.productType = productType;
  }

  /**
   * Gets master data.
   *
   * @return the master data
   */
  public ProductCatalogDataEntity getMasterData() {
    return masterData;
  }

  /**
   * Sets master data.
   *
   * @param masterData the master data
   */
  public void setMasterData(ProductCatalogDataEntity masterData) {
    this.masterData = masterData;
  }

  /**
   * Gets tax category.
   *
   * @return the tax category
   */
  public String getTaxCategory() {
    return taxCategory;
  }

  /**
   * Sets tax category.
   *
   * @param taxCategory the tax category
   */
  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductEntity{"
        + "keyValue='" + keyValue + '\''
        + ", version=" + version
        + ", productType='" + productType + '\''
        + ", masterData=" + masterData
        + ", taxCategory='" + taxCategory + '\''
        + ", state='" + state + '\''
        + '}';
  }
}
