package io.reactivesw.order.order.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.cart.application.model.ShippingInfo;
import io.reactivesw.order.cart.application.model.TaxedPrice;
import io.reactivesw.order.cart.infrastructure.enums.InventoryMode;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import io.reactivesw.order.order.infrastructure.enums.OrderState;
import io.reactivesw.order.order.infrastructure.enums.PaymentState;
import io.reactivesw.order.order.infrastructure.enums.ShipmentState;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
@Data
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
   * It should be unique across a merchant. Once it’s set it cannot be changed.
   */
  private String orderNumber;

  /**
   * The Customer id.
   */
  private String customerId;

  /**
   * Identifies cart and order belonging to an anonymous session
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
//  private List<CustomLineItem> customLineItems;

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
   * Reference to a Cart.
   * Set when this order was created from a cart. The cart will have the state Ordered.
   * Optional.
   */
  private Reference cart;

  /**
   * The Payment info.
   */
  private Reference paymentInfo;

  /**
   * The Inventory mode.
   */
  private InventoryMode inventoryMode;
}
