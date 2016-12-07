package io.reactivesw.order.cart.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Statics;
import io.reactivesw.common.util.CustomFieldsJsonConverter;
import io.reactivesw.common.util.ListJsonConverter;
import io.reactivesw.order.cartdiscount.enums.LineItemPriceMode;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "order_cart_line_item")
public class LineItemValue extends BaseIdEntity {

  /**
   * product id.
   */
  @Column(name = "product_id")
  private String productId;

  /**
   * name in localized string.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * product slug in localized string.
   */
  @OneToMany
  private Set<LocalizedStringEntity> productSlug;

  /**
   * product variant.
   */
  @OneToOne
  private ProductVariantValue variant;

  /**
   * price.
   */
  @OneToOne
  private PriceValue price;

  /**
   * TaxedItemPriceValue.
   */
  @OneToOne
  private TaxedItemPriceValue taxedPrice;

  /**
   * total price.
   */
  @OneToOne
  private MoneyEntity totalPrice;

  /**
   * quantity.
   */
  @Column
  private Integer quantity;

  /**
   * list of item state.
   */
  @OneToMany
  private Set<ItemStateValue> state;

  /**
   * tax rate.
   */
  @OneToOne
  private TaxRateValue taxRate;

  /**
   * supplyChannel.
   */
  @Column(name = "supply_channel")
  private String supplyChannel;

  /**
   * distributionChannel.
   */
  @Column(name = "distribution_channel")
  private String distributionChannel;

  /**
   * DiscountedLineItemPriceForQuantity ids.
   */
  @Column(name = "discount_codes", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> discountedPriceForQuantity;

  /**
   * price mode.
   */
  @Column(name = "price_mode")
  private LineItemPriceMode priceMode;

  /**
   * custom fields.
   */
  @Column(name = "custom", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  /**
   * Gets product id.
   *
   * @return the product id
   */
  public String getProductId() {
    return productId;
  }

  /**
   * Sets product id.
   *
   * @param productId the product id
   */
  public void setProductId(String productId) {
    this.productId = productId;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public Set<LocalizedStringEntity> getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(Set<LocalizedStringEntity> name) {
    this.name = name;
  }

  /**
   * Gets product slug.
   *
   * @return the product slug
   */
  public Set<LocalizedStringEntity> getProductSlug() {
    return productSlug;
  }

  /**
   * Sets product slug.
   *
   * @param productSlug the product slug
   */
  public void setProductSlug(Set<LocalizedStringEntity> productSlug) {
    this.productSlug = productSlug;
  }

  /**
   * Gets variant.
   *
   * @return the variant
   */
  public ProductVariantValue getVariant() {
    return variant;
  }

  /**
   * Sets variant.
   *
   * @param variant the variant
   */
  public void setVariant(ProductVariantValue variant) {
    this.variant = variant;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public PriceValue getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(PriceValue price) {
    this.price = price;
  }

  /**
   * Gets taxed price.
   *
   * @return the taxed price
   */
  public TaxedItemPriceValue getTaxedPrice() {
    return taxedPrice;
  }

  /**
   * Sets taxed price.
   *
   * @param taxedPrice the taxed price
   */
  public void setTaxedPrice(TaxedItemPriceValue taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  /**
   * Gets total price.
   *
   * @return the total price
   */
  public MoneyEntity getTotalPrice() {
    return totalPrice;
  }

  /**
   * Sets total price.
   *
   * @param totalPrice the total price
   */
  public void setTotalPrice(MoneyEntity totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public Set<ItemStateValue> getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(Set<ItemStateValue> state) {
    this.state = state;
  }

  /**
   * Gets tax rate.
   *
   * @return the tax rate
   */
  public TaxRateValue getTaxRate() {
    return taxRate;
  }

  /**
   * Sets tax rate.
   *
   * @param taxRate the tax rate
   */
  public void setTaxRate(TaxRateValue taxRate) {
    this.taxRate = taxRate;
  }

  /**
   * Gets supply channel.
   *
   * @return the supply channel
   */
  public String getSupplyChannel() {
    return supplyChannel;
  }

  /**
   * Sets supply channel.
   *
   * @param supplyChannel the supply channel
   */
  public void setSupplyChannel(String supplyChannel) {
    this.supplyChannel = supplyChannel;
  }

  /**
   * Gets distribution channel.
   *
   * @return the distribution channel
   */
  public String getDistributionChannel() {
    return distributionChannel;
  }

  /**
   * Sets distribution channel.
   *
   * @param distributionChannel the distribution channel
   */
  public void setDistributionChannel(String distributionChannel) {
    this.distributionChannel = distributionChannel;
  }

  /**
   * Gets discounted price per quantity.
   *
   * @return the discounted price per quantity
   */
  public List<String> getDiscountedPriceForQuantity() {
    return discountedPriceForQuantity;
  }

  /**
   * Sets discounted price per quantity.
   *
   * @param discountedPriceForQuantity the discounted price per quantity
   */
  public void setDiscountedPriceForQuantity(List<String> discountedPriceForQuantity) {
    this.discountedPriceForQuantity = discountedPriceForQuantity;
  }

  /**
   * Gets price mode.
   *
   * @return the price mode
   */
  public LineItemPriceMode getPriceMode() {
    return priceMode;
  }

  /**
   * Sets price mode.
   *
   * @param priceMode the price mode
   */
  public void setPriceMode(LineItemPriceMode priceMode) {
    this.priceMode = priceMode;
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
   * to string method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "LineItemValue{"
        + "productId='" + productId + '\''
        + ", name=" + name
        + ", productSlug=" + productSlug
        + ", variant=" + variant
        + ", price=" + price
        + ", taxedPrice=" + taxedPrice
        + ", totalPrice=" + totalPrice
        + ", quantity=" + quantity
        + ", state=" + state
        + ", taxRate=" + taxRate
        + ", supplyChannel='" + supplyChannel + '\''
        + ", distributionChannel='" + distributionChannel + '\''
        + ", discountedPriceForQuantity=" + discountedPriceForQuantity
        + ", priceMode=" + priceMode
        + ", custom=" + custom
        + '}';
  }

  /**
   * hashcode method.
   * Use productId, variantId,supplyChannel,DistributionChannel to generate hashCode.
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(
        this.productId,
        this.variant.getId(),
        this.supplyChannel,
        this.distributionChannel
    );
  }

  /**
   * equals method.
   * Fellow hashcode.
   *
   * @param obj Object, should be LineItemValue
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (this == obj) {
      result = true;
    } else if (obj != null && getClass() == obj.getClass()) {

      LineItemValue other = (LineItemValue) obj;

      result = Objects.equals(this.productId, other.productId)
          && Objects.equals(this.variant.getId(), other.variant.getId())
          && Objects.equals(this.supplyChannel, other.supplyChannel)
          && Objects.equals(this.distributionChannel, other.distributionChannel);
    }
    return result;
  }
}
