package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.catalog.review.model.ReviewRatingStatistics;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.SearchKeyword;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@EqualsAndHashCode
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
  private ProductVariant masterVariant;

  /**
   * variants
   */
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
}
