package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.model.AssetDimensions;
import io.reactivesw.common.util.converter.AssetDimensionsJsonConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "order_image")
@Data
public class ImageValue extends BaseIdEntity {

  /**
   * image url.
   */
  @Column(name = "url")
  private String url;

  /**
   * label.
   */
  @Column(name = "dimensions", columnDefinition = "JSON")
  @Convert(converter = AssetDimensionsJsonConverter.class)
  private AssetDimensions dimensions;

  /**
   * label.
   */
  @Column(name = "label")
  private String label;

}
