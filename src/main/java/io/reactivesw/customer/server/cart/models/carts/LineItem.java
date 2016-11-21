package io.reactivesw.customer.server.cart.models.carts;

import java.util.List;

import io.reactivesw.customer.server.cart.models.orders.ItemState;
import io.reactivesw.customer.server.catalog.models.Price;
import io.reactivesw.customer.server.catalog.models.ProductVariant;
import io.reactivesw.customer.server.cart.enums.carts.LineItemPriceMode;
import io.reactivesw.customer.server.common.types.CustomFields;
import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Money;
import io.reactivesw.customer.server.common.types.Reference;
import io.reactivesw.customer.server.common.types.TaxRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A line item is a snapshot of a product variant at the time it was added to the carts.")
public class LineItem {

  @ApiModelProperty(value = "The unique ID of this LineItem.", required = true)
  private String id;

  @ApiModelProperty(value = "Product Id.", required = true)
  private String productId;

  @ApiModelProperty(value = "The product name.", required = true)
  private LocalizedString name;

  @ApiModelProperty(value =
          "The slug of a product. Added to all line items of carts and orders automatically.",
          required = true)
  private LocalizedString productSlug;

  @ApiModelProperty(value = "ProductVariant", required = true)
  private ProductVariant variant;

  @ApiModelProperty(value =
          "The price of a line item is selected from the prices array of the product variant.",
          required = true)
  private Price price;

  @ApiModelProperty(value = "Set once the taxRate is set.", required = false)
  private TaxedItemPrice taxedPrice;

  @ApiModelProperty(value =
          "The total price of this line item. " +
                  "If the line item is discounted, then the totalPrice is the DiscountedLineItemPriceForQuantity multiplied by quantity. " +
                  "Otherwise the total price is the product price multiplied by the quantity. " +
                  "totalPrice may or may not include the taxes: it depends on the taxRate.includedInPrice property.",
          required = true)
  private Money totalPrice;

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(required = true)
  private List<ItemState> state;

  @ApiModelProperty(value =
          "Will be set automatically in the Platform TaxMode once the shipping address is set is set. " +
                  "For the External tax mode the tax rate has to be set explicitly with the ExternalTaxRateDraft.",
          required = false)
  private TaxRate taxRate;

  @ApiModelProperty(value = "The supply channel identifies the inventory entries that should be reserved. The channel has the role InventorySupply.",
          required = false)
  private Reference supplyChannel;

  @ApiModelProperty(value = "The distribution channel is used to select a ProductPrice. The channel has the role ProductDistribution.",
          required = false)
  private Reference distributionChannel;

  @ApiModelProperty(required = true)
  private List<DiscountedLineItemPriceForQuantity> discountedPricePerQuantity;

  @ApiModelProperty(required = true)
  private LineItemPriceMode priceMode;

  @ApiModelProperty(required = false)
  private CustomFields custom;

}
