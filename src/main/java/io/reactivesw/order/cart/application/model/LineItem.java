package io.reactivesw.order.cart.application.model;

import java.util.List;

import javax.persistence.Id;

import io.reactivesw.order.cartdiscount.application.model.DiscountedLineItemPriceForQuantity;
import io.reactivesw.catalog.product.model.Price;
import io.reactivesw.catalog.product.model.ProductVariant;
import io.reactivesw.order.cartdiscount.infrastructure.enums.LineItemPriceMode;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A line item is a snapshot of a product variant at the time it was added to the cart.")
public class LineItem {

  @ApiModelProperty(value = "The unique ID of this LineItem.", required = true)
  @Id
  private String id;

  @ApiModelProperty(value = "Product Id.", required = true)
  private String productId;

  @ApiModelProperty(value = "The product name.", required = true)
  private LocalizedString name;

  @ApiModelProperty(value =
          "The slug of a product. Added to all line items of cart and order automatically.",
          required = true)
  private LocalizedString productSlug;

  @ApiModelProperty(value = "ProductVariantEntity", required = true)
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public LocalizedString getProductSlug() {
    return productSlug;
  }

  public void setProductSlug(LocalizedString productSlug) {
    this.productSlug = productSlug;
  }

  public ProductVariant getVariant() {
    return variant;
  }

  public void setVariant(ProductVariant variant) {
    this.variant = variant;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public TaxedItemPrice getTaxedPrice() {
    return taxedPrice;
  }

  public void setTaxedPrice(TaxedItemPrice taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  public Money getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Money totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public List<ItemState> getState() {
    return state;
  }

  public void setState(List<ItemState> state) {
    this.state = state;
  }

  public TaxRate getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(TaxRate taxRate) {
    this.taxRate = taxRate;
  }

  public Reference getSupplyChannel() {
    return supplyChannel;
  }

  public void setSupplyChannel(Reference supplyChannel) {
    this.supplyChannel = supplyChannel;
  }

  public Reference getDistributionChannel() {
    return distributionChannel;
  }

  public void setDistributionChannel(Reference distributionChannel) {
    this.distributionChannel = distributionChannel;
  }

  public List<DiscountedLineItemPriceForQuantity> getDiscountedPricePerQuantity() {
    return discountedPricePerQuantity;
  }

  public void setDiscountedPricePerQuantity(List<DiscountedLineItemPriceForQuantity> discountedPricePerQuantity) {
    this.discountedPricePerQuantity = discountedPricePerQuantity;
  }

  public LineItemPriceMode getPriceMode() {
    return priceMode;
  }

  public void setPriceMode(LineItemPriceMode priceMode) {
    this.priceMode = priceMode;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }
}
