package io.reactivesw.customer.server.catalog.models;

import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;
import io.reactivesw.customer.server.common.types.SearchKeywords;

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
  private ZonedDateTime createdAt;
  /**
   * The Last modified at.
   */
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
   * Array of Reference to a Category.
   * References to categories the product is in.
   */
  private List<Reference> categories;

  /**
   * The Category order hints.
   */
  private String categoryOrderHints;
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
  private SearchKeywords searchKeywords;
  /**
   * The Has staged changes.
   */
  private Boolean hasStagedChanges;
  /**
   * The Published.
   */
  private Boolean published;
  /**
   * variants - Array of ProductVariant
   */
  private List<ProductVariant> masterVariant;

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
   * Gets name.
   *
   * @return the name
   */
  public LocalizedString getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(LocalizedString name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public LocalizedString getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  /**
   * Gets slug.
   *
   * @return the slug
   */
  public LocalizedString getSlug() {
    return slug;
  }

  /**
   * Sets slug.
   *
   * @param slug the slug
   */
  public void setSlug(LocalizedString slug) {
    this.slug = slug;
  }

  /**
   * Gets categories.
   *
   * @return the categories
   */
  public List<Reference> getCategories() {
    return categories;
  }

  /**
   * Sets categories.
   *
   * @param categories the categories
   */
  public void setCategories(List<Reference> categories) {
    this.categories = categories;
  }

  /**
   * Gets category order hints.
   *
   * @return the category order hints
   */
  public String getCategoryOrderHints() {
    return categoryOrderHints;
  }

  /**
   * Sets category order hints.
   *
   * @param categoryOrderHints the category order hints
   */
  public void setCategoryOrderHints(String categoryOrderHints) {
    this.categoryOrderHints = categoryOrderHints;
  }

  /**
   * Gets meta title.
   *
   * @return the meta title
   */
  public LocalizedString getMetaTitle() {
    return metaTitle;
  }

  /**
   * Sets meta title.
   *
   * @param metaTitle the meta title
   */
  public void setMetaTitle(LocalizedString metaTitle) {
    this.metaTitle = metaTitle;
  }

  /**
   * Gets meta description.
   *
   * @return the meta description
   */
  public LocalizedString getMetaDescription() {
    return metaDescription;
  }

  /**
   * Sets meta description.
   *
   * @param metaDescription the meta description
   */
  public void setMetaDescription(LocalizedString metaDescription) {
    this.metaDescription = metaDescription;
  }

  /**
   * Gets meta keywords.
   *
   * @return the meta keywords
   */
  public LocalizedString getMetaKeywords() {
    return metaKeywords;
  }

  /**
   * Sets meta keywords.
   *
   * @param metaKeywords the meta keywords
   */
  public void setMetaKeywords(LocalizedString metaKeywords) {
    this.metaKeywords = metaKeywords;
  }

  /**
   * Gets search keywords.
   *
   * @return the search keywords
   */
  public SearchKeywords getSearchKeywords() {
    return searchKeywords;
  }

  /**
   * Sets search keywords.
   *
   * @param searchKeywords the search keywords
   */
  public void setSearchKeywords(SearchKeywords searchKeywords) {
    this.searchKeywords = searchKeywords;
  }

  /**
   * Gets has staged changes.
   *
   * @return the has staged changes
   */
  public Boolean getHasStagedChanges() {
    return hasStagedChanges;
  }

  /**
   * Sets has staged changes.
   *
   * @param hasStagedChanges the has staged changes
   */
  public void setHasStagedChanges(Boolean hasStagedChanges) {
    this.hasStagedChanges = hasStagedChanges;
  }

  /**
   * Gets published.
   *
   * @return the published
   */
  public Boolean getPublished() {
    return published;
  }

  /**
   * Sets published.
   *
   * @param published the published
   */
  public void setPublished(Boolean published) {
    this.published = published;
  }

  /**
   * Gets master variant.
   *
   * @return the master variant
   */
  public List<ProductVariant> getMasterVariant() {
    return masterVariant;
  }

  /**
   * Sets master variant.
   *
   * @param masterVariant the master variant
   */
  public void setMasterVariant(List<ProductVariant> masterVariant) {
    this.masterVariant = masterVariant;
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
    return "ProductProjection{" +
        "id='" + id + '\'' +
        ", key='" + key + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", productType=" + productType +
        ", name=" + name +
        ", description=" + description +
        ", slug=" + slug +
        ", categories=" + categories +
        ", categoryOrderHints='" + categoryOrderHints + '\'' +
        ", metaTitle=" + metaTitle +
        ", metaDescription=" + metaDescription +
        ", metaKeywords=" + metaKeywords +
        ", searchKeywords=" + searchKeywords +
        ", hasStagedChanges=" + hasStagedChanges +
        ", published=" + published +
        ", masterVariant=" + masterVariant +
        ", taxCategory=" + taxCategory +
        ", state=" + state +
        ", reviewRatingStatistics=" + reviewRatingStatistics +
        '}';
  }
}
