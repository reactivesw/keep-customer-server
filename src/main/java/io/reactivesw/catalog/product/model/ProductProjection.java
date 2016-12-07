package io.reactivesw.catalog.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.catalog.review.model.ReviewRatingStatistics;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.SearchKeyword;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductProjection {

  /**
   * The unique ID of the Product.
   */
  private String id;

  /**
   * User-specific unique identifier of the Product.
   */
  private String key;

  /**
   * The current version of the Product.
   */
  private Integer version;

  /**
   * The Created at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;
  /**
   * The Last modified at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * Reference to a ProductType
   */
  private Reference productType;
  /**
   * The Name.
   */
  private LocalizedString name;
  /**
   * The Description.
   */
  private LocalizedString description;
  /**
   * The Slug.
   */
  private LocalizedString slug;
  /**
   * Array of Reference to a CategoryEntity.
   * References to category the product is in.
   */
  private List<Reference> categories;

  /**
   * The CategoryEntity order hints.
   */
  private List<CategoryOrderHint> categoryOrderHints;
  /**
   * The Meta title.
   */
  private LocalizedString metaTitle;
  /**
   * The Meta description.
   */
  private LocalizedString metaDescription;
  /**
   * The Meta keywords.
   */
  private LocalizedString metaKeywords;
  /**
   * The Search keywords.
   */
  private List<SearchKeyword> searchKeyword;
  /**
   * The Has staged changes.
   */
  private Boolean hasStagedChanges;
  /**
   * The Published.
   */
  private Boolean published;
  /**
   * variants - Array of ProductVariantEntity
   */
  private List<ProductVariant> masterVariant;

  private List<ProductVariant> variants;
  /**
   * Reference to a TaxCategory.
   * Optional.
   */
  private Reference taxCategory;

  /**
   * Reference to a State.
   * Optional.
   */
  private Reference state;

  /**
   * Statistics about the review ratings taken into account for this product.
   */
  private ReviewRatingStatistics reviewRatingStatistics;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  public Reference getProductType() {
    return productType;
  }

  public void setProductType(Reference productType) {
    this.productType = productType;
  }

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public LocalizedString getDescription() {
    return description;
  }

  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  public LocalizedString getSlug() {
    return slug;
  }

  public void setSlug(LocalizedString slug) {
    this.slug = slug;
  }

  public List<Reference> getCategories() {
    return categories;
  }

  public void setCategories(List<Reference> categories) {
    this.categories = categories;
  }

  public List<CategoryOrderHint> getCategoryOrderHints() {
    return categoryOrderHints;
  }

  public void setCategoryOrderHints(List<CategoryOrderHint> categoryOrderHints) {
    this.categoryOrderHints = categoryOrderHints;
  }

  public LocalizedString getMetaTitle() {
    return metaTitle;
  }

  public void setMetaTitle(LocalizedString metaTitle) {
    this.metaTitle = metaTitle;
  }

  public LocalizedString getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(LocalizedString metaDescription) {
    this.metaDescription = metaDescription;
  }

  public LocalizedString getMetaKeywords() {
    return metaKeywords;
  }

  public void setMetaKeywords(LocalizedString metaKeywords) {
    this.metaKeywords = metaKeywords;
  }

  public List<SearchKeyword> getSearchKeyword() {
    return searchKeyword;
  }

  public void setSearchKeyword(List<SearchKeyword> searchKeyword) {
    this.searchKeyword = searchKeyword;
  }

  public Boolean getHasStagedChanges() {
    return hasStagedChanges;
  }

  public void setHasStagedChanges(Boolean hasStagedChanges) {
    this.hasStagedChanges = hasStagedChanges;
  }

  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  public List<ProductVariant> getMasterVariant() {
    return masterVariant;
  }

  public void setMasterVariant(List<ProductVariant> masterVariant) {
    this.masterVariant = masterVariant;
  }

  public List<ProductVariant> getVariants() {
    return variants;
  }

  public void setVariants(List<ProductVariant> variants) {
    this.variants = variants;
  }

  public Reference getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(Reference taxCategory) {
    this.taxCategory = taxCategory;
  }

  public Reference getState() {
    return state;
  }

  public void setState(Reference state) {
    this.state = state;
  }

  public ReviewRatingStatistics getReviewRatingStatistics() {
    return reviewRatingStatistics;
  }

  public void setReviewRatingStatistics(ReviewRatingStatistics reviewRatingStatistics) {
    this.reviewRatingStatistics = reviewRatingStatistics;
  }
}
