package io.reactivesw.order.cart.application.model;

import io.reactivesw.catalog.product.application.model.Price;
import io.reactivesw.catalog.product.application.model.ProductVariant;
import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A line item is a snapshot of a product variant at the time it was added " +
    "to the cart.")
@Data
public class LineItem {

  @ApiModelProperty(value = "The unique ID of this LineItem.", required = true)
  @Id
  private String id;

  @ApiModelProperty(value = "Product Id.", required = true)
  private String productId;

  @ApiModelProperty(value = "Product name.", required = true)
  private LocalizedString name;

  @ApiModelProperty(value = "Product slug.", required = true)
  private String slug;

  @ApiModelProperty(value = "product variant", required = true)
  private ProductVariant productVariant;

  @ApiModelProperty(value =
      "The price of a line item is selected from the prices array of the product variant.",
      required = true)
  private Price price;

  @ApiModelProperty(value = "Set once the taxRate is set.")
  private TaxedItemPrice taxedPrice;

  @ApiModelProperty(value =
      "The total price of this line item. " +
          "The total price is the product price multiplied by the quantity. " +
          "totalPrice may or may not include the taxes: it depends on the taxRate.includedInPrice" +
          " property.",
      required = true)
  private Money totalPrice;

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(value = "item state", required = true)
  private ItemState itemState;

  @ApiModelProperty(value =
      "Will be set automatically in the Platform TaxMode once the shipping address is set is set." +
          "For the External tax mode the tax rate has to be set explicitly with the " +
          "ExternalTaxRateDraft.")
  private TaxRate taxRate;

  @ApiModelProperty(value = "The supply channel identifies the inventory entries that should be " +
      "reserved. The channel has the role InventorySupply.")
  private Reference supplyChannel;

  @ApiModelProperty(value = "The distribution channel is used to select a ProductPrice. The " +
      "channel has the role ProductDistribution.")
  private Reference distributionChannel;

}
