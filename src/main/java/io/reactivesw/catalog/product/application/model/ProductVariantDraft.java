package io.reactivesw.catalog.product.application.model;

import io.reactivesw.catalog.product.application.model.attributes.Attribute;
import io.reactivesw.common.model.AssetDraft;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.Pattern;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductVariantDraft {

  /**
   * The Sku.
   */
  @Pattern(regexp = "[-a-zA-Z0-9_]{2,256}", message = "category slug can not match")
  private String sku;

  /**
   * User-specific unique identifier for the variant.
   */
  private String key;

  /**
   * Array of PriceDraft.
   * The prices for the variant draft.
   * Optional.
   */
  private List<PriceDraft> prices;

  /**
   * Array of Image.
   * Optional.
   * External images for the variant draft.
   * You can also upload images to use the commercetools™ platform’s Content Delivery Network.
   */
  private List<Image> images;

  /**
   * Array of AssetDraft.
   * Optional.
   */
  private List<AssetDraft> assets;

  /**
   * Array of AttributeEntity.
   * Optional.
   */
  private List<Attribute> attributes;
}
