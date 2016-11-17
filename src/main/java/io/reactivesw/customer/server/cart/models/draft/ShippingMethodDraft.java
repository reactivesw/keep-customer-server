package io.reactivesw.customer.server.cart.models.draft;

import java.util.List;

import io.reactivesw.customer.server.cart.models.ZoneRate;
import io.reactivesw.customer.server.common.types.Reference;
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

}
