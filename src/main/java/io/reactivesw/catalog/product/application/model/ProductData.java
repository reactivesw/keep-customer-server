package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.SearchKeyword;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
  private List<CategoryOrderHint> categoryOrderHints;

  /**
   * the description.
   */
  private LocalizedString description;

  /**
   * human-readable identifiers usually used as deep-link URL to the related product.
   * Each slug is unique across a merchant,
   * but a product can have the same slug for different languages.
   */
  private String slug;

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
}
