package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.catalog.review.model.ReviewRatingStatistics;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
@ApiModel
public class Product {
  /**
   * The unique ID of the product.
   */
  @ApiModelProperty(required = true)
  private String id;

  /**
   * User-specific unique identifier for the product.
   * Product keys are different from product variant keys.
   */
  @ApiModelProperty(required = false)
  private String key;

  /**
   * The current version of the product.
   */
  @ApiModelProperty(required = true)
  private Integer version;

  /**
   * The Create at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * last modified time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * Reference to a ProductType.
   */
  private Reference productType;

  /**
   * The product data in the master catalog.
   */
  private ProductCatalogData masterData;

  /**
   * Reference to a TaxCategory.
   */
  private Reference taxCategory;

  /**
   * Reference to a State.
   * Optional.
   */
  private Reference state;

  /**
   * Statistics about the review ratings taken into account for this product.
   * Statistics about the review ratings taken into account for this product.
   * Optional.
   */
  private ReviewRatingStatistics reviewRatingStatistics;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets key.
   *
   * @param key the key
   */
  public void setKey(String key) {
    this.key = key;
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
   * Gets created at.
   *
   * @return the created at
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets last modified at.
   *
   * @return the last modified at
   */
  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Sets last modified at.
   *
   * @param lastModifiedAt the last modified at
   */
  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  /**
   * Gets product type.
   *
   * @return the product type
   */
  public Reference getProductType() {
    return productType;
  }

  /**
   * Sets product type.
   *
   * @param productType the product type
   */
  public void setProductType(Reference productType) {
    this.productType = productType;
  }

  /**
   * Gets master data.
   *
   * @return the master data
   */
  public ProductCatalogData getMasterData() {
    return masterData;
  }

  /**
   * Sets master data.
   *
   * @param masterData the master data
   */
  public void setMasterData(ProductCatalogData masterData) {
    this.masterData = masterData;
  }

  /**
   * Gets tax category.
   *
   * @return the tax category
   */
  public Reference getTaxCategory() {
    return taxCategory;
  }

  /**
   * Sets tax category.
   *
   * @param taxCategory the tax category
   */
  public void setTaxCategory(Reference taxCategory) {
    this.taxCategory = taxCategory;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public Reference getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(Reference state) {
    this.state = state;
  }

  /**
   * Gets review rating statistics.
   *
   * @return the review rating statistics
   */
  public ReviewRatingStatistics getReviewRatingStatistics() {
    return reviewRatingStatistics;
  }

  /**
   * Sets review rating statistics.
   *
   * @param reviewRatingStatistics the review rating statistics
   */
  public void setReviewRatingStatistics(ReviewRatingStatistics reviewRatingStatistics) {
    this.reviewRatingStatistics = reviewRatingStatistics;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "Product{" +
        "id='" + id + '\'' +
        ", key='" + key + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", productType=" + productType +
        ", masterData=" + masterData +
        ", taxCategory=" + taxCategory +
        ", state=" + state +
        ", reviewRatingStatistics=" + reviewRatingStatistics +
        '}';
  }
}
