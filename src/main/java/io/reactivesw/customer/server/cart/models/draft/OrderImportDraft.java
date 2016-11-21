package io.reactivesw.customer.server.cart.models.draft;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.customer.server.cart.enums.carts.InventoryMode;
import io.reactivesw.customer.server.cart.models.carts.CustomLineItem;
import io.reactivesw.customer.server.cart.enums.orders.OrderState;
import io.reactivesw.customer.server.cart.enums.orders.PaymentState;
import io.reactivesw.customer.server.cart.enums.orders.ShipmentState;
import io.reactivesw.customer.server.cart.models.carts.ShippingInfo;
import io.reactivesw.customer.server.cart.models.carts.TaxedPrice;
import io.reactivesw.customer.server.common.models.Address;
import io.reactivesw.customer.server.common.models.Money;
import io.reactivesw.customer.server.common.models.Reference;
import io.reactivesw.customer.server.common.models.draft.CustomFieldsDraft;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class OrderImportDraft {

  /**
   * String that unique identifies an order.
   * It can be used to create more human-readable (in contrast to ID) identifier for the order.
   * It should be unique within a project.
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
   * Array of LineItemImportDraft.
   * If not given customLineItems must not be empty.
   * Optional.
   */
  private List<LineItemImportDraft> lineItems;

  /**
   * Array of CustomLineItem.
   * If not given lineItems must not be empty.
   * Optional.
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
   * Reference to a CustomerGroup.
   * Set when the customer is set and the customer is a member of a customer group.
   * Used for product variant price selection.
   * Optional.
   */
  private Reference customerGroup;

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 .
   * Used for product variant price selection.
   */
  private String country;

  /**
   * If not given the Open state will be assigned by default.
   */
  private OrderState orderState;

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
   * The Completed at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime completedAt;

  /***
   * The custom fields.
   */
  private CustomFieldsDraft custom;

  /**
   * If not given the mode None will be assigned by default.
   */
  private InventoryMode inventoryMode;

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

  public List<LineItemImportDraft> getLineItems() {
    return lineItems;
  }

  public void setLineItems(List<LineItemImportDraft> lineItems) {
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

  public ZonedDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(ZonedDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public CustomFieldsDraft getCustom() {
    return custom;
  }

  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }

  public InventoryMode getInventoryMode() {
    return inventoryMode;
  }

  public void setInventoryMode(InventoryMode inventoryMode) {
    this.inventoryMode = inventoryMode;
  }
}
