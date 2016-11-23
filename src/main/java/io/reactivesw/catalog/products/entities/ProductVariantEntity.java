package io.reactivesw.catalog.products.entities;

import io.reactivesw.catalog.products.models.Image;
import io.reactivesw.catalog.products.models.Price;
import io.reactivesw.catalog.products.models.ProductVariantAvailability;
import io.reactivesw.catalog.products.models.ScopedPrice;
import io.reactivesw.catalog.products.models.attributes.Attribute;
import io.reactivesw.common.models.Asset;
import io.reactivesw.common.utils.ListJsonConverter;
import io.reactivesw.common.utils.ProductVariantAvailabilityConverter;
import io.reactivesw.common.utils.ScopedPriceJsonConverter;
import io.swagger.annotations.ApiModelProperty;
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
  private List<String> assetids;

  @Column(name = "availability", columnDefinition = "JSON")
  @Convert(converter = ProductVariantAvailabilityConverter.class)
  private ProductVariantAvailability availability;

  @Column(name = "is_matching")
  private Boolean isMatchingVariant;

  @Column(name = "scoped_price", columnDefinition = "JSON")
  @Convert(converter = ScopedPriceJsonConverter.class)
  private ScopedPrice scopedPrice;

  @Column(name = "scoped_price_discounted")
  private Boolean scopedPriceDiscounted;

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
   * Gets assetids.
   *
   * @return the assetids
   */
  public List<String> getAssetids() {
    return assetids;
  }

  /**
   * Sets assetids.
   *
   * @param assetids the assetids
   */
  public void setAssetids(List<String> assetids) {
    this.assetids = assetids;
  }

  /**
   * Gets availability.
   *
   * @return the availability
   */
  public ProductVariantAvailability getAvailability() {
    return availability;
  }

  /**
   * Sets availability.
   *
   * @param availability the availability
   */
  public void setAvailability(ProductVariantAvailability availability) {
    this.availability = availability;
  }

  /**
   * Gets matching variant.
   *
   * @return the matching variant
   */
  public Boolean getMatchingVariant() {
    return isMatchingVariant;
  }

  /**
   * Sets matching variant.
   *
   * @param matchingVariant the matching variant
   */
  public void setMatchingVariant(Boolean matchingVariant) {
    isMatchingVariant = matchingVariant;
  }

  /**
   * Gets scoped price.
   *
   * @return the scoped price
   */
  public ScopedPrice getScopedPrice() {
    return scopedPrice;
  }

  /**
   * Sets scoped price.
   *
   * @param scopedPrice the scoped price
   */
  public void setScopedPrice(ScopedPrice scopedPrice) {
    this.scopedPrice = scopedPrice;
  }

  /**
   * Gets scoped price discounted.
   *
   * @return the scoped price discounted
   */
  public Boolean getScopedPriceDiscounted() {
    return scopedPriceDiscounted;
  }

  /**
   * Sets scoped price discounted.
   *
   * @param scopedPriceDiscounted the scoped price discounted
   */
  public void setScopedPriceDiscounted(Boolean scopedPriceDiscounted) {
    this.scopedPriceDiscounted = scopedPriceDiscounted;
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
        ", assetids=" + assetids +
        ", availability=" + availability +
        ", isMatchingVariant=" + isMatchingVariant +
        ", scopedPrice=" + scopedPrice +
        ", scopedPriceDiscounted=" + scopedPriceDiscounted +
        '}';
  }
}
