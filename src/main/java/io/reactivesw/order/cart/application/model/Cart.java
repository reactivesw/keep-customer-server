package io.reactivesw.order.cart.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.infrastructure.enums.InventoryMode;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import io.reactivesw.order.discountcode.application.model.DiscountCodeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by umasuo on 16/11/17.
 */
@Data
@ApiModel
public class Cart {

  @ApiModelProperty(value = "The unique ID of the cart.", required = true)
  private String id;

  @ApiModelProperty(value = "The current version of the cart.", required = true)
  private Integer version;

  @ApiModelProperty(value = "Created date time.", required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(value = "Last modified date time.", required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  @ApiModelProperty(value = "Customer Id.", required = false)
  private String customerId;

  @ApiModelProperty(value = "Customer email.", required = false)
  private String customerEmail;

  @ApiModelProperty(value =
      "Identifies cart and order belonging to an anonymous session (the customer has not signed " +
          "up/in yet).",
      required = false)
  private String anonymousId;

  /**
   * The Line items.
   */
  @ApiModelProperty(value = "List of line Item", required = true)
  List<LineItem> lineItems;

  @ApiModelProperty(value = "Array of CustomLineItem", required = true)
  private List<CustomLineItem> customLineItems;

  @ApiModelProperty(value = "Total price", required = true)
  private Money totalPrice;

  @ApiModelProperty(value =
      "Not set until the shipping address is set. Will be set automatically in the Platform " +
          "TaxMode. For the External tax mode it will be set as soon as the external tax rates " +
          "for all line items, custom line items, and shipping in the cart are set.",
      required = false)
  private TaxedPrice taxedPrice;

  @ApiModelProperty(value = "Cart State", required = true)
  private CartState cartState;

  @ApiModelProperty(value = "The shipping address is also used to determine tax rate of the line " +
      "items.", required = false)
  private Address shippingAddress;

  @ApiModelProperty(value = "Billing Address.", required = false)
  private Address billingAddress;

  @ApiModelProperty(value = "Inventory Mode", required = true)
  private InventoryMode inventoryMode;

  @ApiModelProperty(value = "Tax Mode", required = true)
  private TaxMode taxMode;

  @ApiModelProperty(value = "Set automatically when the customer is set and the customer is a " +
      "member of a customer group. Used for product variant price selection.",
      required = false)
  private Reference customerGroup;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 . Used for " +
      "product variant price selection.",
      required = false)
  private String country;

  @ApiModelProperty(value = "Set automatically once the ShippingMethod is set.", required = false)
  private ShippingInfo shippingInfo;

  @ApiModelProperty(value = "List of DiscountCodeInfo.", required = true)
  private List<DiscountCodeInfo> discountCodes;

  @ApiModelProperty(value = "List of DiscountCodeInfo.", required = false)
  private CustomFields custom;

  @ApiModelProperty(value = "PaymentInfo.", required = false)
  private PaymentInfo paymentInfo;

  @ApiModelProperty(value = "String conforming to ↗ IETF language tag ", required = false)
  private String locale;
}
