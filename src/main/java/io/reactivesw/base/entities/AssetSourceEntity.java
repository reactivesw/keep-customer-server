package io.reactivesw.base.entities;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.AssetDimensions;
import io.reactivesw.common.utils.AssetDimensionsJsonConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_asset_source")
public class AssetSourceEntity extends BaseIdEntity {
  /**
   * uri.
   */
  @Column(name = "uri")
  private String uri;

  /**
   * key.
   */
  @Column(name = "asset_source_key")
  private String key;

  /**
   * dimesions.
   */
  @Column(name = "dimensions", columnDefinition = "JSON")
  @Convert(converter = AssetDimensionsJsonConverter.class)
  private AssetDimensions dimensions;

  /**
   * content type.
   */
  @Column(name = "content_type")
  private String contentType;

  /**
   * Gets uri.
   *
   * @return the uri
   */
  public String getUri() {
    return uri;
  }

  /**
   * Sets uri.
   *
   * @param uri the uri
   */
  public void setUri(String uri) {
    this.uri = uri;
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
   * Gets dimensions.
   *
   * @return the dimensions
   */
  public AssetDimensions getDimensions() {
    return dimensions;
  }

  /**
   * Sets dimensions.
   *
   * @param dimensions the dimensions
   */
  public void setDimensions(AssetDimensions dimensions) {
    this.dimensions = dimensions;
  }

  /**
   * Gets content type.
   *
   * @return the content type
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Sets content type.
   *
   * @param contentType the content type
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "AssetSourceEntity{"
        + "id='" + id + '\''
        + ", uri='" + uri + '\''
        + ", key='" + key + '\''
        + ", dimensions=" + dimensions
        + ", contentType='" + contentType + '\''
        + '}';
  }
}
