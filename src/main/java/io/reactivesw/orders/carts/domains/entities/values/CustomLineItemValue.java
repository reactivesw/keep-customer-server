package io.reactivesw.orders.carts.domains.entities.values;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Statics;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.ListJsonConverter;
import io.reactivesw.common.utils.MoneyJsonConverter;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "orders_carts_custom_line_item")
public class CustomLineItemValue extends BaseIdEntity {

  /**
   * name in localized string.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * money.
   */
  @Column(name = "money", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = MoneyJsonConverter.class)
  private Money money;

  /**
   * taxed item price value.
   */
  @OneToOne
  private TaxedItemPriceValue taxedPrice;

  /**
   * total price.
   */
  @Column(name = "total_price", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = MoneyJsonConverter.class)
  private Money totalPrice;

  /**
   * slug.
   */
  @Column
  private String slug;

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
   * tax category.
   */
  @Column(name = "tax_category")
  private String taxCategory;

  /**
   * tax rate id.
   */
  @OneToOne
  private TaxRateValue taxRate;

  /**
   * DiscountedLineItemPriceForQuantity ids.
   */
  @Column(name = "discount_codes", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> discountedPricePerQuantity;

  /**
   * custom fields.
   */
  @Column(name = "custom", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

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
   * Gets money.
   *
   * @return the money
   */
  public Money getMoney() {
    return money;
  }

  /**
   * Sets money.
   *
   * @param money the money
   */
  public void setMoney(Money money) {
    this.money = money;
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
   * Gets slug.
   *
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * Sets slug.
   *
   * @param slug the slug
   */
  public void setSlug(String slug) {
    this.slug = slug;
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
   * Gets tax category.
   *
   * @return the tax category
   */
  public String getTaxCategory() {
    return taxCategory;
  }

  /**
   * Sets tax category.
   *
   * @param taxCategory the tax category
   */
  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
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
   * Gets discounted price per quantity.
   *
   * @return the discounted price per quantity
   */
  public List<String> getDiscountedPricePerQuantity() {
    return discountedPricePerQuantity;
  }

  /**
   * Sets discounted price per quantity.
   *
   * @param discountedPricePerQuantity the discounted price per quantity
   */
  public void setDiscountedPricePerQuantity(List<String> discountedPricePerQuantity) {
    this.discountedPricePerQuantity = discountedPricePerQuantity;
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
}
