package io.reactivesw.products.models;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.Reference;
import io.reactivesw.common.models.ResourceIdentifier;
import io.reactivesw.common.models.SearchKeyword;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductDraft {
  /**
   * User-specific unique identifier for the product.
   */
  private String key;

  /**
   * the name.
   */
  private LocalizedString name;

  /**
   * ResourceIdentifier to a ProductType.
   * a predefined product type must be assigned to the product.
   * Required.
   */
//TODO don't know what is the meaning of ResourceIdentifier.
  private ResourceIdentifier productType;

  /**
   * human-readable identifiers usually used as deep-link URL to the related product. Each slug
   * must be unique across a project, but a product can have the same slug for different
   * languages. Allowed are alphabetic, numeric, underscore (_) and hyphen (-) characters.
   * Maximum size is 256.
   */
  private LocalizedString slug;

  /**
   * the description.
   */
  private LocalizedString description;

  /**
   * categories that are assigned to the product.
   * Array of Reference to a Category.
   * Optional.
   */
  private List<Reference> categories;

  /**
   * CategoryOrderHints.
   */
  //TODO String should be CategoryOrderHints.
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
   * The Master variant.
   */
  private ProductVariantDraft masterVariant;

  /**
   * Array of ProductVariantDraft.
   * An array specifying further product variants.
   * Optional.
   */
  private List<ProductVariantDraft> variants;

  /**
   * Reference to a TaxCategory.
   * Optional.
   */
  private Reference taxCategory;

  /**
   * The Search keywords.
   */
  private SearchKeyword searchKeyword;

  /**
   * Reference to an initial State.
   * Optional.
   */
  private Reference state;

  /**
   * Optional, defaults to false.
   * If true, the product will be published immediately.
   */
  private Boolean publish;

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
   * Gets product type.
   *
   * @return the product type
   */
  public ResourceIdentifier getProductType() {
    return productType;
  }

  /**
   * Sets product type.
   *
   * @param productType the product type
   */
  public void setProductType(ResourceIdentifier productType) {
    this.productType = productType;
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
  public List<CategoryOrderHint> getCategoryOrderHints() {
    return categoryOrderHints;
  }

  /**
   * Sets category order hints.
   *
   * @param categoryOrderHints the category order hints
   */
  public void setCategoryOrderHints(List<CategoryOrderHint> categoryOrderHints) {
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
   * Gets master variant.
   *
   * @return the master variant
   */
  public ProductVariantDraft getMasterVariant() {
    return masterVariant;
  }

  /**
   * Sets master variant.
   *
   * @param masterVariant the master variant
   */
  public void setMasterVariant(ProductVariantDraft masterVariant) {
    this.masterVariant = masterVariant;
  }

  /**
   * Gets variants.
   *
   * @return the variants
   */
  public List<ProductVariantDraft> getVariants() {
    return variants;
  }

  /**
   * Sets variants.
   *
   * @param variants the variants
   */
  public void setVariants(List<ProductVariantDraft> variants) {
    this.variants = variants;
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
   * Gets search keywords.
   *
   * @return the search keywords
   */
  public SearchKeyword getSearchKeyword() {
    return searchKeyword;
  }

  /**
   * Sets search keywords.
   *
   * @param searchKeyword the search keywords
   */
  public void setSearchKeyword(SearchKeyword searchKeyword) {
    this.searchKeyword = searchKeyword;
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
   * Gets publish.
   *
   * @return the publish
   */
  public Boolean getPublish() {
    return publish;
  }

  /**
   * Sets publish.
   *
   * @param publish the publish
   */
  public void setPublish(Boolean publish) {
    this.publish = publish;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ProductDraft{" +
            "key='" + key + '\'' +
            ", name=" + name +
            ", productType=" + productType +
            ", slug=" + slug +
            ", description=" + description +
            ", categories=" + categories +
            ", categoryOrderHints='" + categoryOrderHints + '\'' +
            ", metaTitle=" + metaTitle +
            ", metaDescription=" + metaDescription +
            ", metaKeywords=" + metaKeywords +
            ", masterVariant=" + masterVariant +
            ", variants=" + variants +
            ", taxCategory=" + taxCategory +
            ", searchKeyword=" + searchKeyword +
            ", state=" + state +
            ", publish=" + publish +
            '}';
  }
}
