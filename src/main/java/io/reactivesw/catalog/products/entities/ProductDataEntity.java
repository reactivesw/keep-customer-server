package io.reactivesw.catalog.products.entities;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/23.
 */
@Entity
@Table(name = "catalog_product_data")
public class ProductDataEntity extends BaseIdEntity {
  /**
   * JSON TYPE.
   */
  private static final String JSONTYPE = "JSON";

  /**
   * name.
   */
  @Column(name = "name", nullable = false, columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString name;

  /**
   * description.
   */
  @Column(name = "description", nullable = false, columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString description;

  /**
   * slug.
   */
  @Column(name = "slug", nullable = false, columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString slug;

  /**
   * meta title.
   */
  @Column(name = "meta_title", nullable = false, columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaTitle;


  /**
   * meta description.
   */
  @Column(name = "meta_description", nullable = false, columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaDescription;

  /**
   * meta key words.
   */
  @Column(name = "meta_keywords", nullable = false, columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaKeywords;

  /**
   * search key words.
   */
  @Column(name = "search_key_words")
  private String searchKeyWords;

  /**
   * master variant.
   */
  @OneToOne
  private ProductVariantEntity masterVariant;

  /**
   * variants.
   */
  @OneToMany
  private Set<ProductVariantEntity> variants;

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
   * Gets search key words.
   *
   * @return the search key words
   */
  public String getSearchKeyWords() {
    return searchKeyWords;
  }

  /**
   * Sets search key words.
   *
   * @param searchKeyWords the search key words
   */
  public void setSearchKeyWords(String searchKeyWords) {
    this.searchKeyWords = searchKeyWords;
  }

  /**
   * Gets master variant.
   *
   * @return the master variant
   */
  public ProductVariantEntity getMasterVariant() {
    return masterVariant;
  }

  /**
   * Sets master variant.
   *
   * @param masterVariant the master variant
   */
  public void setMasterVariant(ProductVariantEntity masterVariant) {
    this.masterVariant = masterVariant;
  }

  /**
   * Gets variants.
   *
   * @return the variants
   */
  public Set<ProductVariantEntity> getVariants() {
    return variants;
  }

  /**
   * Sets variants.
   *
   * @param variants the variants
   */
  public void setVariants(Set<ProductVariantEntity> variants) {
    this.variants = variants;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductDataEntity{"
        + "name=" + name
        + ", description=" + description
        + ", slug=" + slug
        + ", metaTitle=" + metaTitle
        + ", metaDescription=" + metaDescription
        + ", metaKeywords=" + metaKeywords
        + ", searchKeyWords='" + searchKeyWords + '\''
        + ", masterVariant=" + masterVariant
        + ", variants=" + variants
        + '}';
  }
}
