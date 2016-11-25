package io.reactivesw.catalog.products.entities;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.SearchKeyword;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;

/**
 * Created by umasuo on 16/11/23.
 */
@Entity
@Table(name = "catalog_product_data")
public class ProductDataEntity extends BaseIdEntity {

  @Column(name = "name", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString name;

  @Column(name = "description", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString description;

  @Column(name = "slug", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString slug;

  @Column(name = "meta_title", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaTitle;


  @Column(name = "meta_description", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaDescription;

  @Column(name = "meta_keywords", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaKeywords;

  @Column(name = "search_key_words")
  private String searchKeyWords;

  @OneToOne
  private ProductVariantEntity masterVariant;

  @OneToMany
  private Set<ProductVariantEntity> variants;
}
