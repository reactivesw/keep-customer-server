package io.reactivesw.catalog.taxcategories.models;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * External TaxRates are never included in the price, therefore includedInPrice will be set to false
 * automatically. Created by umasuo on 16/11/18.
 */
@ApiModel(description = "External TaxRates are never included in the price, therefore includedInPrice will be set to false automatically.")
public class ExternalTaxRateDraft {

  @ApiModelProperty(required = true)
  private String name;

  @ApiModelProperty(value = "Percentage in the range of [0..1]. Must be supplied if no subRates are specified. " +
          "If subRates are specified then the amount can be omitted or it must be the sum of the amounts of all subRates.",
          required = false)
  private Float amount;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 .", required = true)
  private String country;

  @ApiModelProperty(value = "The state in the country", required = true)
  private String state;

  @ApiModelProperty(value = "For countries (e.g. the US) where the total tax is a combination of multiple taxes (e.g. state and local taxes).", required = false)
  List<SubRate> subRates;

}
