package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.util.converter.ListJsonConverter;
import lombok.Data;
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

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "order_cart_product_variant")
@Data
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

}
