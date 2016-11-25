package io.reactivesw.catalog.products.entities;

import io.reactivesw.catalog.products.models.ProductVariantAvailability;
import io.reactivesw.catalog.products.models.ScopedPrice;
import io.reactivesw.common.utils.ListJsonConverter;
import io.reactivesw.common.utils.ProductVariantAvailabilityConverter;
import io.reactivesw.common.utils.ScopedPriceJsonConverter;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Set;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_product_variant")
public class ProductVariantEntity {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "variant_id")
  private String variantId;

  @Column(name = "product_variant_id", nullable = false)
  private Integer id;

  @Column(name = "sku_name")
  private String sku;

  @Column(name = "product_variant_key")
  private String key;

  @OneToMany
  private Set<PriceEntity> prices;

  @OneToMany
  private Set<AttributeEntity> attributes;

  @OneToMany
  private Set<ImageEntity> images;

  @Column(name = "asset_id", columnDefinition = "JSON")
  @Convert(converter = ListJsonConverter.class)
  private List<String> assetIds;

  /**
   * Gets variant id.
   *
   * @return the variant id
   */
  public String getVariantId() {
    return variantId;
  }

  /**
   * Sets variant id.
   *
   * @param variantId the variant id
   */
  public void setVariantId(String variantId) {
    this.variantId = variantId;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Integer id) {
    this.id = id;
  }

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
  public Set<PriceEntity> getPrices() {
    return prices;
  }

  /**
   * Sets prices.
   *
   * @param prices the prices
   */
  public void setPrices(Set<PriceEntity> prices) {
    this.prices = prices;
  }

  /**
   * Gets attributes.
   *
   * @return the attributes
   */
  public Set<AttributeEntity> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(Set<AttributeEntity> attributes) {
    this.attributes = attributes;
  }

  /**
   * Gets images.
   *
   * @return the images
   */
  public Set<ImageEntity> getImages() {
    return images;
  }

  /**
   * Sets images.
   *
   * @param images the images
   */
  public void setImages(Set<ImageEntity> images) {
    this.images = images;
  }

  /**
   * Gets assetIds.
   *
   * @return the assetIds
   */
  public List<String> getAssetIds() {
    return assetIds;
  }

  /**
   * Sets assetIds.
   *
   * @param assetIds the assetIds
   */
  public void setAssetIds(List<String> assetIds) {
    this.assetIds = assetIds;
  }

  @Override
  public String toString() {
    return "ProductVariantEntity{" +
        "variantId='" + variantId + '\'' +
        ", id=" + id +
        ", sku='" + sku + '\'' +
        ", key='" + key + '\'' +
        ", prices=" + prices +
        ", attributes=" + attributes +
        ", images=" + images +
        ", assetIds=" + assetIds +
        '}';
  }
}
