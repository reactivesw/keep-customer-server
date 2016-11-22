package io.reactivesw.carts.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.discountcodes.models.DiscountCodeInfo;
import io.reactivesw.carts.enums.CartState;
import io.reactivesw.carts.enums.InventoryMode;
import io.reactivesw.carts.enums.TaxMode;
import io.reactivesw.common.models.Address;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class Cart {

  @ApiModelProperty(value = "The unique ID of the carts.", required = true)
  private String id;

  @ApiModelProperty(value = "The current version of the carts.", required = true)
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
          "Identifies carts and orders belonging to an anonymous session (the customer has not signed up/in yet).",
          required = false)
  private String anonymousId;

  @ApiModelProperty(value = "List of line Item", required = true)
  List<LineItem> lineItems;

  @ApiModelProperty(value = "Array of CustomLineItem", required = true)
  private List<CustomLineItem> customLineItems;

  @ApiModelProperty(value = "Total price", required = true)
  private Money totalPrice;

  @ApiModelProperty(value =
          "Not set until the shipping address is set. Will be set automatically in the Platform TaxMode. For the External tax mode it will be set as soon as the external tax rates for all line items, custom line items, and shipping in the carts are set.",
          required = false)
  private TaxedPrice taxedPrice;

  @ApiModelProperty(value = "Cart State", required = true)
  private CartState cartState;

  @ApiModelProperty(value = "The shipping address is also used to determine tax rate of the line items.", required = false)
  private Address shippingAddress;

  @ApiModelProperty(value = "Billing Address.", required = false)
  private Address billingAddress;

  @ApiModelProperty(value = "Inventory Mode", required = true)
  private InventoryMode inventoryMode;

  @ApiModelProperty(value = "Tax Mode", required = true)
  private TaxMode taxMode;

  @ApiModelProperty(value = "Set automatically when the customer is set and the customer is a member of a customer group. Used for product variant price selection.",
          required = false)
  private Reference customerGroup;

  @ApiModelProperty(value = "A two-digit country code as per ↗ ISO 3166-1 alpha-2 . Used for product variant price selection.",
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public String getAnonymousId() {
    return anonymousId;
  }

  public void setAnonymousId(String anonymousId) {
    this.anonymousId = anonymousId;
  }

  public List<LineItem> getLineItems() {
    return lineItems;
  }

  public void setLineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
  }

  public List<CustomLineItem> getCustomLineItems() {
    return customLineItems;
  }

  public void setCustomLineItems(List<CustomLineItem> customLineItems) {
    this.customLineItems = customLineItems;
  }

  public Money getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Money totalPrice) {
    this.totalPrice = totalPrice;
  }

  public TaxedPrice getTaxedPrice() {
    return taxedPrice;
  }

  public void setTaxedPrice(TaxedPrice taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  public CartState getCartState() {
    return cartState;
  }

  public void setCartState(CartState cartState) {
    this.cartState = cartState;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public Address getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
  }

  public InventoryMode getInventoryMode() {
    return inventoryMode;
  }

  public void setInventoryMode(InventoryMode inventoryMode) {
    this.inventoryMode = inventoryMode;
  }

  public TaxMode getTaxMode() {
    return taxMode;
  }

  public void setTaxMode(TaxMode taxMode) {
    this.taxMode = taxMode;
  }

  public Reference getCustomerGroup() {
    return customerGroup;
  }

  public void setCustomerGroup(Reference customerGroup) {
    this.customerGroup = customerGroup;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ShippingInfo getShippingInfo() {
    return shippingInfo;
  }

  public void setShippingInfo(ShippingInfo shippingInfo) {
    this.shippingInfo = shippingInfo;
  }

  public List<DiscountCodeInfo> getDiscountCodes() {
    return discountCodes;
  }

  public void setDiscountCodes(List<DiscountCodeInfo> discountCodes) {
    this.discountCodes = discountCodes;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  public PaymentInfo getPaymentInfo() {
    return paymentInfo;
  }

  public void setPaymentInfo(PaymentInfo paymentInfo) {
    this.paymentInfo = paymentInfo;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }
}
