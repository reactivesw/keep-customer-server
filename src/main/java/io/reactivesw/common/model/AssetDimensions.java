package io.reactivesw.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "The width and height of the asset source.")
public class AssetDimensions {

  @ApiModelProperty(value = "The width of the asset source", required = true)
  private float w;
  @ApiModelProperty(value = "The height of the asset source", required = true)
  private float h;

  public float getW() {
    return w;
  }

  public void setW(float w) {
    this.w = w;
  }

  public float getH() {
    return h;
  }

  public void setH(float h) {
    this.h = h;
  }
}
