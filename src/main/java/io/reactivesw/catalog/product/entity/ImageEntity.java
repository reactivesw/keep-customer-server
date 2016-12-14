package io.reactivesw.catalog.product.entity;

import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.model.AssetDimensions;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@Entity
@Table(name = "catalog_product_image")
@TypeDef(name = "Dimensions", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "io.reactivesw.common.model.AssetDimensions")}
)
public class ImageEntity extends BaseIdEntity {

  /**
   * url.
   */
  @Column(name = "url")
  private String url;

  /**
   * dimensions.
   */
  @Type(type = "Dimensions")
  private AssetDimensions dimensions;

  /**
   * label.
   */
  @Column(name = "label")
  private String label;
}
