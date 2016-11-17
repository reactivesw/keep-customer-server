package io.reactivesw.customer.server.catalog.models;

import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;

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
   * Array of Reference to a Category
   * References to categories the product is in.
   */
  private List<Reference> categories;

  /**
   * categoryOrderHints.
   */
  //TODO String should be CategoryOrderHints
  private String categoryOrderHints;

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
  List<ProductVariant> variants;


}
