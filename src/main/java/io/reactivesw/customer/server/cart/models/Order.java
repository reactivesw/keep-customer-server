package io.reactivesw.customer.server.cart.models;

import io.reactivesw.customer.server.cart.SyncInfo;
import io.reactivesw.customer.server.cart.enums.InventoryMode;
import io.reactivesw.customer.server.cart.enums.OrderState;
import io.reactivesw.customer.server.cart.enums.PaymentState;
import io.reactivesw.customer.server.cart.enums.ShipmentState;
import io.reactivesw.customer.server.cart.enums.TaxMode;
import io.reactivesw.customer.server.common.types.Address;
import io.reactivesw.customer.server.common.types.CustomFields;
import io.reactivesw.customer.server.common.types.Money;
import io.reactivesw.customer.server.common.types.Reference;

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
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  private ZonedDateTime lastModifiedAt;

  /**
   * This field will only be present if it was set for Order Import
   */
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
   * Set when this order was created from a cart. The cart will have the state Ordered.
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
}
