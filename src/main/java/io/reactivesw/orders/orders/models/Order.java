package io.reactivesw.orders.orders.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.orders.carts.enums.InventoryMode;
import io.reactivesw.orders.carts.models.PaymentInfo;
import io.reactivesw.orders.orders.enums.OrderState;
import io.reactivesw.orders.orders.enums.PaymentState;
import io.reactivesw.orders.orders.enums.ShipmentState;
import io.reactivesw.orders.carts.enums.TaxMode;
import io.reactivesw.orders.carts.models.CustomLineItem;
import io.reactivesw.orders.discountcodes.models.DiscountCodeInfo;
import io.reactivesw.orders.carts.models.LineItem;
import io.reactivesw.orders.carts.models.ShippingInfo;
import io.reactivesw.orders.carts.models.TaxedPrice;
import io.reactivesw.common.models.Address;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Reference;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by Davis on 16/11/17.
 */
public class Order {

  /**
   * The unique ID of the order.
   */
  private String id;

  /**
   * The current version of the order.
   */
  private Integer version;

  /**
   * The Created at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * This field will only be present if it was set for Order Import
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime completedAt;

  /**
   * String that uniquely identifies an order.
   * It can be used to create more human-readable (in contrast to ID) identifier for the order.
   * It should be unique across a project. Once it’s set it cannot be changed.
   */
  private String orderNumber;

  /**
   * The Customer id.
   */
  private String customerId;

  /**
   * The Customer email.
   */
  private String customerEmail;

  /**
   * Identifies carts and orders belonging to an anonymous session
   * (the customer has not signed up/in yet).
   */
  private String anonymousId;

  /**
   * Array of LineItem.
   */
  private List<LineItem> lineItems;

  /**
   * Array of CustomLineItem.
   */
  private List<CustomLineItem> customLineItems;

  /**
   * The Total price.
   */
  private Money totalPrice;

  /**
   * The taxes are calculated based on the shipping address.
   */
  private TaxedPrice taxedPrice;

  /**
   * The Shipping address.
   */
  private Address shippingAddress;

  /**
   * The Billing address.
   */
  private Address billingAddress;

  /**
   * The Tax mode.
   */
  private TaxMode taxMode;

  /**
   * Reference to a CustomerGroup.
   * Set when the customer is set and the customer is a member of a customer group.
   * Used for product variant price selection.
   * Optional.
   */
  private Reference customerGroup;

  /**
   * A two-digit country code as per ISO 3166-1 alpha-2 . Used for product variant price selection.
   */
  private String country;

  /**
   * One of the four predefined OrderStates.
   */
  private OrderState orderState;

  /**
   * Reference to a State.
   * This reference can point to a state in a custom workflow.
   * Optional.
   */
  private Reference state;

  /**
   * The Shipment state.
   */
  private ShipmentState shipmentState;

  /**
   * The Payment state.
   */
  private PaymentState paymentState;

  /**
   * Set if the ShippingMethod is set.
   */
  private ShippingInfo shippingInfo;

  /**
   * Set of ReturnItem.
   */
  private Set<SyncInfo> syncInfo;

  /**
   * Set of ReturnInfo.
   */
  private Set<ReturnInfo> returnInfo;

  /**
   * Array of DiscountCodeInfo.
   */
  private List<DiscountCodeInfo> discountCodes;

  /**
   * The sequence number of the last order message produced by changes to this order.
   * 0 means, that no messages were created yet.
   */
  private Integer lastMessageSequenceNumber;

  /**
   * Reference to a Cart.
   * Set when this order was created from a carts. The carts will have the state Ordered.
   * Optional.
   */
  private Reference cart;

  /**
   * The Custom.
   */
  private CustomFields custom;

  /**
   * The Payment info.
   */
  private PaymentInfo paymentInfo;

  /**
   * conforming to IETF language tag.
   * Optional.
   */
  private String locale;

  /**
   * The Inventory mode.
   */
  private InventoryMode inventoryMode;

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

  public ZonedDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(ZonedDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
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

  public OrderState getOrderState() {
    return orderState;
  }

  public void setOrderState(OrderState orderState) {
    this.orderState = orderState;
  }

  public Reference getState() {
    return state;
  }

  public void setState(Reference state) {
    this.state = state;
  }

  public ShipmentState getShipmentState() {
    return shipmentState;
  }

  public void setShipmentState(ShipmentState shipmentState) {
    this.shipmentState = shipmentState;
  }

  public PaymentState getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(PaymentState paymentState) {
    this.paymentState = paymentState;
  }

  public ShippingInfo getShippingInfo() {
    return shippingInfo;
  }

  public void setShippingInfo(ShippingInfo shippingInfo) {
    this.shippingInfo = shippingInfo;
  }

  public Set<SyncInfo> getSyncInfo() {
    return syncInfo;
  }

  public void setSyncInfo(Set<SyncInfo> syncInfo) {
    this.syncInfo = syncInfo;
  }

  public Set<ReturnInfo> getReturnInfo() {
    return returnInfo;
  }

  public void setReturnInfo(Set<ReturnInfo> returnInfo) {
    this.returnInfo = returnInfo;
  }

  public List<DiscountCodeInfo> getDiscountCodes() {
    return discountCodes;
  }

  public void setDiscountCodes(List<DiscountCodeInfo> discountCodes) {
    this.discountCodes = discountCodes;
  }

  public Integer getLastMessageSequenceNumber() {
    return lastMessageSequenceNumber;
  }

  public void setLastMessageSequenceNumber(Integer lastMessageSequenceNumber) {
    this.lastMessageSequenceNumber = lastMessageSequenceNumber;
  }

  public Reference getCart() {
    return cart;
  }

  public void setCart(Reference cart) {
    this.cart = cart;
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

  public InventoryMode getInventoryMode() {
    return inventoryMode;
  }

  public void setInventoryMode(InventoryMode inventoryMode) {
    this.inventoryMode = inventoryMode;
  }
}
