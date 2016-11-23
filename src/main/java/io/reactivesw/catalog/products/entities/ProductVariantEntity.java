package io.reactivesw.catalog.products.entities;

import io.reactivesw.catalog.products.models.Image;
import io.reactivesw.catalog.products.models.Price;
import io.reactivesw.catalog.products.models.ProductVariantAvailability;
import io.reactivesw.catalog.products.models.ScopedPrice;
import io.reactivesw.catalog.products.models.attributes.Attribute;
import io.reactivesw.common.models.Asset;
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
  private Set<Attribute> attributes;

  @OneToMany
  private Set<ImageEntity> images;

  @OneToMany
  private Set<Asset> assets;

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
}
