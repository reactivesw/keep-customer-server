package io.reactivesw.catalog.product.model;

import io.reactivesw.common.model.AssetDimensions;
import io.swagger.annotations.ApiModel;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class Image {
  /**
   * URL of the image in its original size.
   * This can be used to obtain the image in different sizes.
   */
  private String url;

  /**
   * Dimensions of the original image.
   * This can be used by your application e.g. to determine
   * whether the image is large enough to display a zoom view.
   */
  //TODO String may not ok?
  private AssetDimensions dimensions;

  /**
   * Custom label that can be used, for example, as an image description.
   */
  private String label;

  /**
   * Gets url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets url.
   *
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
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
   * Gets label.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets label.
   *
   * @param label the label
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Image{" +
            "url='" + url + '\'' +
            ", dimensions='" + dimensions + '\'' +
            ", label='" + label + '\'' +
            '}';
  }
}
