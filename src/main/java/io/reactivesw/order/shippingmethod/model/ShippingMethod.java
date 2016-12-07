package io.reactivesw.order.shippingmethod.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A shipping method defines a specific way of shipping, with different rates for different geographic locations. Example shipping methods are “DHL”, “DHL Express” and “UPS”.
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A shipping method defines a specific way of shipping, with different rates for different geographic locations. Example shipping methods are “DHL”, “DHL Express” and “UPS”.")
public class ShippingMethod {

  @ApiModelProperty(value = "The unique ID of the shipping method.", required = true)
  private String id;

  @ApiModelProperty(value = "The current version of the shipping method.",required = true)
  private Integer version;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(required = false)
  private String description;

  @ApiModelProperty(value = "Reference to a TaxCategory", required = true)
  private Reference taxCategory;

  @ApiModelProperty(required = true)
  private List<ZoneRate> zoneRates;

  @ApiModelProperty(value = "One shipping method in a project can be default.", required = true)
  private Boolean isDefault;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

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
