package io.reactivesw.customer.server.cart.models;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.customer.server.common.types.Reference;
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
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = true)
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

}
