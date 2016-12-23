package io.reactivesw.catalog.product.application.model;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.ResourceIdentifier;
import io.reactivesw.common.model.SearchKeyword;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@EqualsAndHashCode
public class ProductDraft {
  /**
   * User-specific unique identifier for the product.
   */
  private String key;

  /**
   * the name.
   */
  @NotNull(message = "product name can not bu null")
  private LocalizedString name;

  /**
   * ResourceIdentifier to a ProductType.
   * a predefined product type must be assigned to the product.
   * Required.
   */
  private ResourceIdentifier productType;

  /**
   * human-readable identifiers usually used as deep-link URL to the related product. Each slug
   * must be unique across a project, but a product can have the same slug for different
   * languages. Allowed are alphabetic, numeric, underscore (_) and hyphen (-) characters.
   * Maximum size is 256.
   */
  @NotNull(message = "product slug can not be null")
  @Pattern(regexp = "[-a-zA-Z0-9_]{2,256}", message = "product slug not match")
  private String slug;

  /**
   * the description.
   */
  private LocalizedString description;

  /**
   * category that are assigned to the product.
   * Array of Reference to a CategoryEntity.
   * Optional.
   */
  private List<Reference> categories;

  /**
   * CategoryOrderHints.
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

}
