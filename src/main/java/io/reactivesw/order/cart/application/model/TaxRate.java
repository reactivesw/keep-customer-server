package io.reactivesw.order.cart.application.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
@Data
public class TaxRate {

  @ApiModelProperty(value = "The id is always set if the tax rate is part of a TaxCategory. The " +
      "external tax rates in a Cart do not contain an id.")
  private String id;

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(value = "Number Percentage in the range of [0..1]. The sum of the amounts of " +
      "all subRates, if there are any.",
      required = true)
  private Float amount;

  @ApiModelProperty(required = true)
  private Boolean includedInPrice;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 .",
      required = true)
  private String country;

  @ApiModelProperty(value = "The state in the country")
  private String state;

  @ApiModelProperty(value = "For countries (e.g. the US) where the total tax is a combination of " +
      "multiple taxes (e.g. state and local taxes).",
      required = true)
  private List<SubRate> subRates;

}
