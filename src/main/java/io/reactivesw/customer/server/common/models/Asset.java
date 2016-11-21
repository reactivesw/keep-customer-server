package io.reactivesw.customer.server.common.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<AssetSource> getSources() {
    return sources;
  }

  public void setSources(List<AssetSource> sources) {
    this.sources = sources;
  }

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public LocalizedString getDescription() {
    return description;
  }

  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }
}
