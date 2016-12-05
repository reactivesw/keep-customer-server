package io.reactivesw.orders.carts.applications.models.actions;

import io.reactivesw.catalog.taxcategories.models.ExternalTaxRateDraft;
import io.reactivesw.common.models.CustomFieldsDraft;
import io.reactivesw.common.models.Reference;
import io.reactivesw.common.models.UpdateAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/12/1.
 */
@ApiModel
public class AddLineItem extends UpdateAction {
  @ApiModelProperty(required = true)
  private String action;

  /**
   * Id of an existing Product.
   */
  @ApiModelProperty(required = true)
  private String productId;

  /**
   * Id of an existing ProductVariant in the product.
   */
  @ApiModelProperty(required = true)
  private Integer variantId;

  /**
   * default to 1.
   */
  @ApiModelProperty(required = false)
  private Integer quantity;

  /**
   * By providing supply channel information, you can unique identify inventory entries that
   * should be reserved. Provided channel should have the role InventorySupply.
   */
  @ApiModelProperty(required = false)
  private Reference supplyChannel;

  /**
   * The channel is used to select a ProductPrice. Provided channel should have the role
   * ProductDistribution.
   */
  @ApiModelProperty(required = false)
  private Reference distributionChannel;

  /**
   * An external tax rate can be set if the cart has the External TaxMode.
   */
  @ApiModelProperty(required = false)
  private ExternalTaxRateDraft externalTaxRate;

  /**
   * The custom fields.
   */
  @ApiModelProperty(required = false)
  CustomFieldsDraft custom;

  /**
   * Gets action.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Sets action.
   *
   * @param action the action
   */
  public void setAction(String action) {
    this.action = action;
  }

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
    return "AddLineItem{"
        + "action='" + action + '\''
        + ", productId='" + productId + '\''
        + ", variantId=" + variantId
        + ", quantity=" + quantity
        + ", supplyChannel=" + supplyChannel
        + ", distributionChannel=" + distributionChannel
        + ", externalTaxRate=" + externalTaxRate
        + ", custom=" + custom
        + '}';
  }
}
