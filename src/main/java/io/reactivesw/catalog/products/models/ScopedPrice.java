package io.reactivesw.catalog.products.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.reactivesw.catalog.productdiscounts.models.DiscountedPrice;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "Scoped price is returned as a part of a variant in product search (when price selector is used).")
public class ScopedPrice {

  @ApiModelProperty(value = "The unique ID of this price.",
          required = true,
          readOnly = true)
  private String id;

  @ApiModelProperty(value = "the original price value",required = true)
  private Money value;

  @ApiModelProperty(value = "either the original price value or the discounted value, if it’s available",required = true)
  private Money currentValue;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 .",required = false)
  private String country;

  @ApiModelProperty(value = "A reference to a customer group.", required = false)
  private Reference customerGroup;

  @ApiModelProperty(value = "A reference to a channel.",required = false)
  private Reference channel;

  @ApiModelProperty(value = "Date from which the price is valid.",
          required = false)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime validFrom;

  @ApiModelProperty(value = "Date until which the price is valid.", required = false)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime validUntil;

  @ApiModelProperty(value = "Is set if a matching ProductDiscount exists. If set, the Cart will use the discounted value for the carts price calculation.\n" +
          "  When a relative discount is applied and the fraction part of the discounted price is 0.5, the discounted price is rounded in favor of the customer with the half down rounding.",
          required = false)
  private DiscountedPrice discounted;

  @ApiModelProperty(required = false)
  private CustomFields custom;
}
