package io.reactivesw.order.shippingmethod.application.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This representation needs to be given with a Create ShippingMethod request.
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "This representation needs to be given with a Create ShippingMethod " +
    "request.")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingMethodDraft {

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(required = false)
  private String description;

  @ApiModelProperty(required = true)
  private Reference taxCategory;

  @ApiModelProperty(required = true)
  private List<ZoneRate> zoneRates;

  @ApiModelProperty(value = "If true the shipping method will be the default one in a project.",
      required = true)
  private Boolean isDefault;

}
