package io.reactivesw.order.order.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.order.order.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import io.reactivesw.order.order.domain.entity.value.BillingAddressValue;
import io.reactivesw.order.order.domain.entity.value.ShippingAddressValue;
import io.reactivesw.order.order.domain.entity.value.ShippingInfoValue;
import io.reactivesw.order.order.domain.entity.value.TaxedPriceValue;
import io.reactivesw.order.order.infrastructure.enums.OrderState;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by umasuo on 17/1/6.
 */
@Entity
@Table(name = "order_order")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  @Version
  private Integer version;

  /**
   * complete time.
   */
  @Column(name = "complete_at")
  private ZonedDateTime completedAt;

  /**
   * String that uniquely identifies an order. It can be used to create more human-readable (in
   * contrast to ID) identifier for the order. It should be unique across a merchant. Once it’s
   * set it cannot be changed.
   */
  @Column(name = "order_name")
  private String orderName;

  /**
   * customer id.
   */
  @Column(name = "customer_id")
  private String customerId;

  /**
   * anonymous id.
   */
  @Column(name = "anonymous_id")
  private String anonymousId;

  /**
   * List of line items.
   */
  @OneToMany
  private Set<LineItemValue> lineItems;

  /**
   * total price.
   */
  @OneToOne
  private MoneyEntity totalPrice;

  /**
   * Not set until the shipping address is set. Will be set automatically in the Platform TaxMode.
   * For the External tax mode it will be set as soon as the external tax rates for all line items,
   * custom line items, and shipping in the cart are set.
   */
  @OneToOne
  private TaxedPriceValue taxedPrice;

  /**
   * the shipping address.
   */
  @OneToOne
  private ShippingAddressValue shippingAddress;

  /**
   * the billing address.
   */
  @OneToOne
  private BillingAddressValue billingAddress;

  /**
   * tax mode.
   */
  @Column
  private TaxMode taxMode;

  /**
   * Set automatically when the customer is set and the customer is a member of a customer group.
   * Used for product variant price selection.
   */
  @Column
  private String customerGroup;

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 . Used for product variant price
   * selection.
   */
  @Column
  private String country;

  /**
   * order state.
   */
  @Column
  private OrderState orderState;

  /**
   * Set automatically once the ShippingMethod is set.
   */
  @OneToOne
  private ShippingInfoValue shippingInfo;

  /**
   * payment id.
   */
  @Column
  private String paymentInfo;
}
