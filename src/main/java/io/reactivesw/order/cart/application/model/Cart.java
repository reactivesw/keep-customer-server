package io.reactivesw.order.cart.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.order.discountcode.application.model.DiscountCodeInfo;
import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.infrastructure.enums.InventoryMode;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import io.reactivesw.common.model.Address;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
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
          "Identifies cart and order belonging to an anonymous session (the customer has not signed up/in yet).",
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
          "Not set until the shipping address is set. Will be set automatically in the Platform TaxMode. For the External tax mode it will be set as soon as the external tax rates for all line items, custom line items, and shipping in the cart are set.",
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

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets last modified at.
   *
   * @return the last modified at
   */
  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Sets last modified at.
   *
   * @param lastModifiedAt the last modified at
   */
  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  /**
   * Gets customer id.
   *
   * @return the customer id
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * Sets customer id.
   *
   * @param customerId the customer id
   */
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  /**
   * Gets customer email.
   *
   * @return the customer email
   */
  public String getCustomerEmail() {
    return customerEmail;
  }

  /**
   * Sets customer email.
   *
   * @param customerEmail the customer email
   */
  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  /**
   * Gets anonymous id.
   *
   * @return the anonymous id
   */
  public String getAnonymousId() {
    return anonymousId;
  }

  /**
   * Sets anonymous id.
   *
   * @param anonymousId the anonymous id
   */
  public void setAnonymousId(String anonymousId) {
    this.anonymousId = anonymousId;
  }

  /**
   * Gets line items.
   *
   * @return the line items
   */
  public List<LineItem> getLineItems() {
    return lineItems;
  }

  /**
   * Sets line items.
   *
   * @param lineItems the line items
   */
  public void setLineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
  }

  /**
   * Gets custom line items.
   *
   * @return the custom line items
   */
  public List<CustomLineItem> getCustomLineItems() {
    return customLineItems;
  }

  /**
   * Sets custom line items.
   *
   * @param customLineItems the custom line items
   */
  public void setCustomLineItems(List<CustomLineItem> customLineItems) {
    this.customLineItems = customLineItems;
  }

  /**
   * Gets total price.
   *
   * @return the total price
   */
  public Money getTotalPrice() {
    return totalPrice;
  }

  /**
   * Sets total price.
   *
   * @param totalPrice the total price
   */
  public void setTotalPrice(Money totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * Gets taxed price.
   *
   * @return the taxed price
   */
  public TaxedPrice getTaxedPrice() {
    return taxedPrice;
  }

  /**
   * Sets taxed price.
   *
   * @param taxedPrice the taxed price
   */
  public void setTaxedPrice(TaxedPrice taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  /**
   * Gets cart state.
   *
   * @return the cart state
   */
  public CartState getCartState() {
    return cartState;
  }

  /**
   * Sets cart state.
   *
   * @param cartState the cart state
   */
  public void setCartState(CartState cartState) {
    this.cartState = cartState;
  }

  /**
   * Gets shipping address.
   *
   * @return the shipping address
   */
  public Address getShippingAddress() {
    return shippingAddress;
  }

  /**
   * Sets shipping address.
   *
   * @param shippingAddress the shipping address
   */
  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  /**
   * Gets billing address.
   *
   * @return the billing address
   */
  public Address getBillingAddress() {
    return billingAddress;
  }

  /**
   * Sets billing address.
   *
   * @param billingAddress the billing address
   */
  public void setBillingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
  }

  /**
   * Gets inventory mode.
   *
   * @return the inventory mode
   */
  public InventoryMode getInventoryMode() {
    return inventoryMode;
  }

  /**
   * Sets inventory mode.
   *
   * @param inventoryMode the inventory mode
   */
  public void setInventoryMode(InventoryMode inventoryMode) {
    this.inventoryMode = inventoryMode;
  }

  /**
   * Gets tax mode.
   *
   * @return the tax mode
   */
  public TaxMode getTaxMode() {
    return taxMode;
  }

  /**
   * Sets tax mode.
   *
   * @param taxMode the tax mode
   */
  public void setTaxMode(TaxMode taxMode) {
    this.taxMode = taxMode;
  }

  /**
   * Gets customer group.
   *
   * @return the customer group
   */
  public Reference getCustomerGroup() {
    return customerGroup;
  }

  /**
   * Sets customer group.
   *
   * @param customerGroup the customer group
   */
  public void setCustomerGroup(Reference customerGroup) {
    this.customerGroup = customerGroup;
  }

  /**
   * Gets country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets country.
   *
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Gets shipping info.
   *
   * @return the shipping info
   */
  public ShippingInfo getShippingInfo() {
    return shippingInfo;
  }

  /**
   * Sets shipping info.
   *
   * @param shippingInfo the shipping info
   */
  public void setShippingInfo(ShippingInfo shippingInfo) {
    this.shippingInfo = shippingInfo;
  }

  /**
   * Gets discount codes.
   *
   * @return the discount codes
   */
  public List<DiscountCodeInfo> getDiscountCodes() {
    return discountCodes;
  }

  /**
   * Sets discount codes.
   *
   * @param discountCodes the discount codes
   */
  public void setDiscountCodes(List<DiscountCodeInfo> discountCodes) {
    this.discountCodes = discountCodes;
  }

  /**
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFields getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  /**
   * Gets payment info.
   *
   * @return the payment info
   */
  public PaymentInfo getPaymentInfo() {
    return paymentInfo;
  }

  /**
   * Sets payment info.
   *
   * @param paymentInfo the payment info
   */
  public void setPaymentInfo(PaymentInfo paymentInfo) {
    this.paymentInfo = paymentInfo;
  }

  /**
   * Gets locale.
   *
   * @return the locale
   */
  public String getLocale() {
    return locale;
  }

  /**
   * Sets locale.
   *
   * @param locale the locale
   */
  public void setLocale(String locale) {
    this.locale = locale;
  }
}
