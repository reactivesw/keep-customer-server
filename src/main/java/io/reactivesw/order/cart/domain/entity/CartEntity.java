package io.reactivesw.order.cart.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Statics;
import io.reactivesw.common.util.CustomFieldsJsonConverter;
import io.reactivesw.common.util.ListJsonConverter;
import io.reactivesw.order.cart.domain.entity.value.BillingAddressValue;
import io.reactivesw.order.cart.domain.entity.value.CustomLineItemValue;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.domain.entity.value.ShippingAddressValue;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;
import io.reactivesw.order.cart.domain.entity.value.TaxedPriceValue;
import io.reactivesw.order.cart.infrastructure.enums.CartState;
import io.reactivesw.order.cart.infrastructure.enums.InventoryMode;
import io.reactivesw.order.cart.infrastructure.enums.TaxMode;
import lombok.Data;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * cart entity.
 * Created by umasuo on 16/11/25.
 */
@Entity
@Table(name = "order_cart_cart")
@Data
public class CartEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Column
  private Integer version;

  /**
   * customer id.
   */
  @Column(name = "customer_id")
  private String customerId;

  /**
   * customer email.
   */
  @Column(name = "customer_email")
  private String customerEmail;

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
   * list of custom line items.
   */
  @OneToMany
  private Set<CustomLineItemValue> customLineItems;

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
   * cart status.
   */
  @Column
  private CartState cartState;

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
   * inventory mode.
   */
  @Column
  private InventoryMode inventoryMode;

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
   * Set automatically once the ShippingMethod is set.
   */
  @OneToOne
  private ShippingInfoValue shippingInfo;

  /**
   * the id list of discount codes.
   */
  @Column(name = "discount_codes", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> discountCodes;

  /**
   * custom fields.
   */
  @Column(name = "custom", columnDefinition = Statics.JSON)
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  /**
   * list of payment id.
   */
  @Column(name = "payment_info", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> paymentInfo;

  /**
   * locale.
   */
  @Column
  private String locale;


}
