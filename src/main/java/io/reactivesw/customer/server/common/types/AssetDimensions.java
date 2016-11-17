package io.reactivesw.customer.server.common.types;

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
}
