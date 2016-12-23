package io.reactivesw.catalog.product.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/23.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "catalog_product_data")
public class ProductDataEntity extends BaseIdEntity {

  /**
   * name.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> name;

  /**
   * description.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> description;

  /**
   * slug.
   */
  @Column
  private String slug;

  /**
   * meta title.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> metaTitle;


  /**
   * meta description.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> metaDescription;

  /**
   * meta key words.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> metaKeywords;

  /**
   * search key words.
   */
  @Column(name = "search_key_words")
  private String searchKeyWords;

  /**
   * master variant.
   */
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ProductVariantEntity masterVariant;

  /**
   * variants.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<ProductVariantEntity> variants;

  /**
   * categoryOrderHints.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<CategoryOrderHintEntity> categoryOrderHints;

  /**
   * categories.
   */
  @ElementCollection
  private Set<String> categories;
}
