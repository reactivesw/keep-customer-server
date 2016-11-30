package io.reactivesw.orders.carts.domains.entities.values;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.reactivesw.common.utils.ListJsonConverter;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "orders_carts_product_variant")
public class ProductVariantValue {

  /**
   * id use uuid.
   */
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "variant_id")
  private String variantId;

  /**
   * id in number.
   */
  @Column(name = "product_variant_id", nullable = false)
  private Integer id;

  /**
   * sku.
   */
  @Column(name = "sku_name")
  private String sku;

  /**
   * key.
   */
  @Column(name = "product_variant_key")
  private String key;

  /**
   * list of price.
   */
  @OneToMany
  private Set<PriceValue> prices;

  /**
   * list of attribute.
   */
  @OneToMany
  private Set<AttributeValue> attributes;

  /**
   * list of images.
   */
  @OneToMany
  private Set<ImageValue> images;

  /**
   * list of asset ids.
   */
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
  public Set<PriceValue> getPrices() {
    return prices;
  }

  /**
   * Sets prices.
   *
   * @param prices the prices
   */
  public void setPrices(Set<PriceValue> prices) {
    this.prices = prices;
  }

  /**
   * Gets attributes.
   *
   * @return the attributes
   */
  public Set<AttributeValue> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(Set<AttributeValue> attributes) {
    this.attributes = attributes;
  }

  /**
   * Gets images.
   *
   * @return the images
   */
  public Set<ImageValue> getImages() {
    return images;
  }

  /**
   * Sets images.
   *
   * @param images the images
   */
  public void setImages(Set<ImageValue> images) {
    this.images = images;
  }

  /**
   * Gets asset ids.
   *
   * @return the asset ids
   */
  public List<String> getAssetIds() {
    return assetIds;
  }

  /**
   * Sets asset ids.
   *
   * @param assetIds the asset ids
   */
  public void setAssetIds(List<String> assetIds) {
    this.assetIds = assetIds;
  }
}
