package io.reactivesw.orders.carts.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.ListJsonConverter;
import io.reactivesw.common.utils.MoneyJsonConverter;
import io.reactivesw.orders.carts.entities.values.AddressValue;
import io.reactivesw.orders.carts.entities.values.CustomLineItemValue;
import io.reactivesw.orders.carts.entities.values.LineItemValue;
import io.reactivesw.orders.carts.entities.values.PaymentInfoValue;
import io.reactivesw.orders.carts.entities.values.ShippingInfoValue;
import io.reactivesw.orders.carts.entities.values.TaxedPriceValue;
import io.reactivesw.orders.carts.enums.CartState;
import io.reactivesw.orders.carts.enums.InventoryMode;
import io.reactivesw.orders.carts.enums.TaxMode;

/**
 * cart entity.
 * Created by umasuo on 16/11/25.
 */
@Entity
@Table(name = "orders_carts_cart")
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
  @Column(name = "total_price", nullable = false, columnDefinition = "JSON")
  @Convert(converter = MoneyJsonConverter.class)
  private Money totalPrice;

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
  private AddressValue shippingAddress;

  /**
   * the billing address.
   */
  @OneToOne
  private AddressValue billingAddress;

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
  @Column(name = "discount_codes", columnDefinition = "JSON")
  @Convert(converter = ListJsonConverter.class)
  private List<String> discountCodes;

  /**
   * custom fields.
   */
  @Column(name = "custom", columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  /**
   * payment info.
   */
  @OneToOne
  private PaymentInfoValue paymentInfo;

  /**
   * locale.
   */
  @Column
  private String locale;

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
  public Set<LineItemValue> getLineItems() {
    return lineItems;
  }

  /**
   * Sets line items.
   *
   * @param lineItems the line items
   */
  public void setLineItems(Set<LineItemValue> lineItems) {
    this.lineItems = lineItems;
  }

  /**
   * Gets custom line items.
   *
   * @return the custom line items
   */
  public Set<CustomLineItemValue> getCustomLineItems() {
    return customLineItems;
  }

  /**
   * Sets custom line items.
   *
   * @param customLineItems the custom line items
   */
  public void setCustomLineItems(Set<CustomLineItemValue> customLineItems) {
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
  public TaxedPriceValue getTaxedPrice() {
    return taxedPrice;
  }

  /**
   * Sets taxed price.
   *
   * @param taxedPrice the taxed price
   */
  public void setTaxedPrice(TaxedPriceValue taxedPrice) {
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
  public AddressValue getShippingAddress() {
    return shippingAddress;
  }

  /**
   * Sets shipping address.
   *
   * @param shippingAddress the shipping address
   */
  public void setShippingAddress(AddressValue shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  /**
   * Gets billing address.
   *
   * @return the billing address
   */
  public AddressValue getBillingAddress() {
    return billingAddress;
  }

  /**
   * Sets billing address.
   *
   * @param billingAddress the billing address
   */
  public void setBillingAddress(AddressValue billingAddress) {
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
  public String getCustomerGroup() {
    return customerGroup;
  }

  /**
   * Sets customer group.
   *
   * @param customerGroup the customer group
   */
  public void setCustomerGroup(String customerGroup) {
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
  public ShippingInfoValue getShippingInfo() {
    return shippingInfo;
  }

  /**
   * Sets shipping info.
   *
   * @param shippingInfo the shipping info
   */
  public void setShippingInfo(ShippingInfoValue shippingInfo) {
    this.shippingInfo = shippingInfo;
  }

  /**
   * Gets discount codes.
   *
   * @return the discount codes
   */
  public List<String> getDiscountCodes() {
    return discountCodes;
  }

  /**
   * Sets discount codes.
   *
   * @param discountCodes the discount codes
   */
  public void setDiscountCodes(List<String> discountCodes) {
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
  public PaymentInfoValue getPaymentInfo() {
    return paymentInfo;
  }

  /**
   * Sets payment info.
   *
   * @param paymentInfo the payment info
   */
  public void setPaymentInfo(PaymentInfoValue paymentInfo) {
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
