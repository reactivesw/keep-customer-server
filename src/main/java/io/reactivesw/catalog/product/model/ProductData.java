package io.reactivesw.catalog.product.model;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.SearchKeyword;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductData {
  /**
   * the name.
   */
  private LocalizedString name;

  /**
   * Array of Reference to a CategoryEntity
   * References to category the product is in.
   */
  private List<Reference> categories;

  /**
   * categoryOrderHints.
   */
  //TODO String should be CategoryOrderHints
  private List<CategoryOrderHint> categoryOrderHints;

  /**
   * the description.
   */
  private LocalizedString description;

  /**
   * human-readable identifiers usually used as deep-link URL to the related product.
   * Each slug is unique across a project,
   * but a product can have the same slug for different languages.
   */
  private LocalizedString slug;

  /**
   * the meta title.
   * optional.
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
   * masterVariant.
   */
  private ProductVariant masterVariant;

  /**
   * The Variants.
   */
  private List<ProductVariant> variants;

  /**
   * search keyword.
   */
  private SearchKeyword searchKeyword;

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
   * Gets category.
   *
   * @return the category
   */
  public List<Reference> getCategories() {
    return categories;
  }

  /**
   * Sets category.
   *
   * @param categories the category
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
  public ProductVariant getMasterVariant() {
    return masterVariant;
  }

  /**
   * Sets master variant.
   *
   * @param masterVariant the master variant
   */
  public void setMasterVariant(ProductVariant masterVariant) {
    this.masterVariant = masterVariant;
  }

  /**
   * Gets variants.
   *
   * @return the variants
   */
  public List<ProductVariant> getVariants() {
    return variants;
  }

  /**
   * Sets variants.
   *
   * @param variants the variants
   */
  public void setVariants(List<ProductVariant> variants) {
    this.variants = variants;
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
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ProductData{" +
            "name=" + name +
            ", category=" + categories +
            ", categoryOrderHints='" + categoryOrderHints + '\'' +
            ", description=" + description +
            ", slug=" + slug +
            ", metaTitle=" + metaTitle +
            ", metaDescription=" + metaDescription +
            ", metaKeywords=" + metaKeywords +
            ", masterVariant=" + masterVariant +
            ", variants=" + variants +
            ", searchKeyword=" + searchKeyword +
            '}';
  }
}
