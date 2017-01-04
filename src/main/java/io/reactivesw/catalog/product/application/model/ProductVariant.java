package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.reactivesw.catalog.product.application.model.attributes.Attribute;
import io.reactivesw.common.model.Asset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

import java.util.List;

/**
 * Created by umasuo on 16/11/17.
 */
@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVariant {

  @ApiModelProperty(value = "The sequential ID of the variant within the product.", required = true)
  private Integer id;

  @ApiModelProperty(value = "The SKU of the variant.")
  private String sku;

  @ApiModelProperty(value = "User-specific unique identifier for the variant. Product variant " +
      "keys are different from product keys.")
  private String key;

  @ApiModelProperty(value = "The prices of the variant. " +
      "The prices does not contain two prices for the same price scope (same currency, country, " +
      "customer group and channel).",
      required = false)
  private List<Price> prices;

  @ApiModelProperty(required = false)
  private List<Attribute> attributes;

  @ApiModelProperty(value = "Only appears when price selection is used. This field cannot be used" +
      " in a query predicate.", required = false)
  private Price price;

  @ApiModelProperty(required = false)
  private List<Image> images;

  @ApiModelProperty(required = false)
  private List<Asset> assets;

  @ApiModelProperty(value = "The availability is set if the variant is tracked by the inventory. " +
      "The field might not contain the latest inventory state (it is eventually consistent) and " +
      "can be used as an optimization to reduce calls to the inventory service.",
      required = false)
  private ProductVariantAvailability availability;

  @ApiModelProperty(value = "Only appears in response to a Product Projection Search request to " +
      "mark this variant as one that matches the search query.",
      required = false)
  private Boolean isMatchingVariant;

  @ApiModelProperty(value = "Only appears when price selection is used.",
      required = false)
  private ScopedPrice scopedPrice;

  @ApiModelProperty(value = "Only appears in response to a Product Projection Search request when" +
      " price selection is used.", required = false)
  private Boolean scopedPriceDiscounted;

}
