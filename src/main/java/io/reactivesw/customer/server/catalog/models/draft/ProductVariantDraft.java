package io.reactivesw.customer.server.catalog.models.draft;

import io.reactivesw.customer.server.catalog.models.Attribute;
import io.reactivesw.customer.server.catalog.models.Image;
import io.reactivesw.customer.server.common.models.draft.AssetDraft;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductVariantDraft {

  /**
   * The Sku.
   */
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
   * Array of Attribute.
   * Optional.
   */
  private List<Attribute> attributes;

  /**
   * Gets sku.
   *
   * @return the sku
   */
  public String getSku() {
    return sku;
  }

  /**
   * Sets sku.
   *
   * @param sku the sku
   */
  public void setSku(String sku) {
    this.sku = sku;
  }

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
   * Gets prices.
   *
   * @return the prices
   */
  public List<PriceDraft> getPrices() {
    return prices;
  }

  /**
   * Sets prices.
   *
   * @param prices the prices
   */
  public void setPrices(List<PriceDraft> prices) {
    this.prices = prices;
  }

  /**
   * Gets images.
   *
   * @return the images
   */
  public List<Image> getImages() {
    return images;
  }

  /**
   * Sets images.
   *
   * @param images the images
   */
  public void setImages(List<Image> images) {
    this.images = images;
  }

  /**
   * Gets assets.
   *
   * @return the assets
   */
  public List<AssetDraft> getAssets() {
    return assets;
  }

  /**
   * Sets assets.
   *
   * @param assets the assets
   */
  public void setAssets(List<AssetDraft> assets) {
    this.assets = assets;
  }

  /**
   * Gets attributes.
   *
   * @return the attributes
   */
  public List<Attribute> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductVariantDraft{" +
        "sku='" + sku + '\'' +
        ", key='" + key + '\'' +
        ", prices=" + prices +
        ", images=" + images +
        ", assets=" + assets +
        ", attributes=" + attributes +
        '}';
  }
}
