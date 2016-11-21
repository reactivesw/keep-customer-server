package io.reactivesw.carts.models;

import io.reactivesw.taxcategories.models.ExternalTaxRateDraft;
import io.reactivesw.common.models.Reference;
import io.reactivesw.types.models.CustomFieldsDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A line item is a snapshot of a product variant at the time it was added to the carts.")
public class LineItemDraft {

  @ApiModelProperty(value = "Product Id.", required = true)
  private String productId;

  @ApiModelProperty(value = "ProductVariant id", required = true)
  private Integer variantId;

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(value = "The supply channel identifies the inventory entries that should be reserved. The channel has the role InventorySupply.",
          required = false)
  private Reference supplyChannel;

  @ApiModelProperty(value = "The distribution channel is used to select a ProductPrice. The channel has the role ProductDistribution.",
          required = false)
  private Reference distributionChannel;

  @ApiModelProperty(value = "An external tax rate can be set if the carts has the External TaxMode.",
          required = false)
  private ExternalTaxRateDraft externalTaxRate;

  @ApiModelProperty(required = false)
  private CustomFieldsDraft custom;

}
