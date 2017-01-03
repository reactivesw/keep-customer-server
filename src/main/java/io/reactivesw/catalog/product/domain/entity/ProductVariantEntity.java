package io.reactivesw.catalog.product.domain.entity;

import io.reactivesw.common.dialect.JSONBUserType;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@Entity
@Table(name = "catalog_product_variant")
@TypeDef(name = "List", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "java.util.List")}
)
public class ProductVariantEntity {
  /**
   * id for the entity.
   */
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "variant_id")
  private String variantId;

  /**
   * id for product variant.
   */
  @Column(name = "product_variant_id", nullable = false)
  private Integer id;

  /**
   * sku name.
   */
  @Column(name = "sku_name")
  private String sku;

  /**
   * product variant key.
   */
  @Column(name = "product_variant_key")
  private String key;

  /**
   * prices.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<PriceEntity> prices;

  /**
   * attributes.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<AttributeEntity> attributes;

  /**
   * images.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<ImageEntity> images;

  /**
   * assetIds.
   */
  @Type(type = "List")
  private List<String> assetIds;
}
