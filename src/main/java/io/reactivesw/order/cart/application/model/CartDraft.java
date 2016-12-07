package io.reactivesw.order.cart.application.model;

import java.util.List;

import io.reactivesw.order.cart.infrastructure.enums.InventoryMode;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import io.reactivesw.catalog.taxcategory.model.ExternalTaxRateDraft;
import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.CustomFieldsDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class CartDraft {

  @ApiModelProperty(value = "A three-digit currency code as per ↗ ISO 4217 .", required = true)
  private String currency;

  @ApiModelProperty(value = "Customer Id.", required = false)
  private String customerId;

  @ApiModelProperty(value = "Customer email.", required = false)
  private String customerEmail;

  @ApiModelProperty(value =
          "Identifies cart and order belonging to an anonymous session (the customer has not signed up/in yet).",
          required = false)
  private String anonymousId;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 . Used for product variant price selection.",
          required = false)
  private String country;

  @ApiModelProperty(value = "Inventory Mode", required = true)
  private InventoryMode inventoryMode;

  @ApiModelProperty(value = "Tax Mode", required = true)
  private TaxMode taxMode;

  @ApiModelProperty(value = "List of line Item", required = true)
  private List<LineItemDraft> lineItems;

  @ApiModelProperty(value = "Array of CustomLineItem", required = true)
  private List<CustomLineItemDraft> customLineItems;

  @ApiModelProperty(value = "The shipping address is also used to determine tax rate of the line items.", required = false)
  private Address shippingAddress;

  @ApiModelProperty(value = "Billing Address.", required = false)
  private Address billingAddress;

  @ApiModelProperty(value = "Reference to a ShippingMethod.", required = false)
  private Reference shippingMethod;

  @ApiModelProperty(value = "An external tax rate can be set for the shippingMethod if the cart has the External TaxMode..", required = false)
  private ExternalTaxRateDraft externalTaxRateForShippingMethod;

  @ApiModelProperty(value = "List of DiscountCodeInfo.", required = false)
  private CustomFieldsDraft custom;

  @ApiModelProperty(value = "String conforming to ↗ IETF language tag ", required = false)
  private String locale;
}
