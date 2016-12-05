package io.reactivesw.orders.carts.applications.models;

import io.reactivesw.catalog.taxcategories.models.ExternalTaxRateDraft;
import io.reactivesw.common.models.CustomFieldsDraft;
import io.reactivesw.common.models.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A line item is a snapshot of a product variant at the time it was added " +
    "to the carts.")
public class LineItemDraft {

  @ApiModelProperty(value = "Product Id.", required = true)
  private String productId;

  @ApiModelProperty(value = "ProductVariantEntity id", required = true)
  private Integer variantId;

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(value = "The supply channel identifies the inventory entries that should be " +
      "reserved. The channel has the role InventorySupply.",
      required = false)
  private Reference supplyChannel;

  @ApiModelProperty(value = "The distribution channel is used to select a ProductPrice. The " +
      "channel has the role ProductDistribution.",
      required = false)
  private Reference distributionChannel;

  @ApiModelProperty(value = "An external tax rate can be set if the carts has the External " +
      "TaxMode.",
      required = false)
  private ExternalTaxRateDraft externalTaxRate;

  @ApiModelProperty(required = false)
  private CustomFieldsDraft custom;

  /**
   * Gets product id.
   *
   * @return the product id
   */
  public String getProductId() {
    return productId;
  }

  /**
   * Sets product id.
   *
   * @param productId the product id
   */
  public void setProductId(String productId) {
    this.productId = productId;
  }

  /**
   * Gets variant id.
   *
   * @return the variant id
   */
  public Integer getVariantId() {
    return variantId;
  }

  /**
   * Sets variant id.
   *
   * @param variantId the variant id
   */
  public void setVariantId(Integer variantId) {
    this.variantId = variantId;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets supply channel.
   *
   * @return the supply channel
   */
  public Reference getSupplyChannel() {
    return supplyChannel;
  }

  /**
   * Sets supply channel.
   *
   * @param supplyChannel the supply channel
   */
  public void setSupplyChannel(Reference supplyChannel) {
    this.supplyChannel = supplyChannel;
  }

  /**
   * Gets distribution channel.
   *
   * @return the distribution channel
   */
  public Reference getDistributionChannel() {
    return distributionChannel;
  }

  /**
   * Sets distribution channel.
   *
   * @param distributionChannel the distribution channel
   */
  public void setDistributionChannel(Reference distributionChannel) {
    this.distributionChannel = distributionChannel;
  }

  /**
   * Gets external tax rate.
   *
   * @return the external tax rate
   */
  public ExternalTaxRateDraft getExternalTaxRate() {
    return externalTaxRate;
  }

  /**
   * Sets external tax rate.
   *
   * @param externalTaxRate the external tax rate
   */
  public void setExternalTaxRate(ExternalTaxRateDraft externalTaxRate) {
    this.externalTaxRate = externalTaxRate;
  }

  /**
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFieldsDraft getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }

  /**
   * to string method.
   *
   * @return
   */
  @Override
  public String toString() {
    return "LineItemDraft{"
        + "productId='" + productId + '\''
        + ", variantId=" + variantId
        + ", quantity=" + quantity
        + ", supplyChannel=" + supplyChannel
        + ", distributionChannel=" + distributionChannel
        + ", externalTaxRate=" + externalTaxRate
        + ", custom=" + custom
        + '}';
  }
}
