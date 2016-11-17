package io.reactivesw.customer.server.common.types;

import java.util.List;

import io.reactivesw.customer.server.customer.models.CustomFields;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "An Asset can be used to represent media assets, such as images, videos or PDFs.\n" +
        "Please find more information about use of Assets in the respective tutorial.\n")
public class Asset {
  @ApiModelProperty(required = true)
  private String id;

  @ApiModelProperty(value = "Array of AssetSource - Has at least one entry", required = true)
  private List<AssetSource> sources;

  @ApiModelProperty(value = " Localized String", required = true)
  private LocalizedString name;

  @ApiModelProperty(value = "Localized String",required = false)

  private LocalizedString description;

  @ApiModelProperty(required = false)
  private List<String> tags;

  @ApiModelProperty(value = "CustomFields",required = false)
  private CustomFields custom;
}
