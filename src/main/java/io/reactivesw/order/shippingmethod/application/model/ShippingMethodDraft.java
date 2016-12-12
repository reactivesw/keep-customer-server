package io.reactivesw.order.shippingmethod.application.model;

import java.util.List;

import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This representation needs to be given with a Create ShippingMethod request.
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "This representation needs to be given with a Create ShippingMethod request.")
public class ShippingMethodDraft {

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(required = false)
  private String description;

  @ApiModelProperty(required = true)
  private Reference taxCategory;

  @ApiModelProperty(required = true)
  private List<ZoneRate> zoneRates;

  @ApiModelProperty(value = "If true the shipping method will be the default one in a project.", required = true)
  private Boolean isDefault;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Reference getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(Reference taxCategory) {
    this.taxCategory = taxCategory;
  }

  public List<ZoneRate> getZoneRates() {
    return zoneRates;
  }

  public void setZoneRates(List<ZoneRate> zoneRates) {
    this.zoneRates = zoneRates;
  }

  public Boolean getDefault() {
    return isDefault;
  }

  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }
}
