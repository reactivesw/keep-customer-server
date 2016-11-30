package io.reactivesw.orders.carts.domains.entities.values;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.entities.MoneyEntity;
import io.reactivesw.common.utils.ListJsonConverter;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "orders_carts_shipping_info_value")
public class ShippingInfoValue extends BaseIdEntity {

  /**
   * shipping method name.
   */
  @Column(name = "shipping_method_name")
  private String shippingMethodName;

  /**
   * price.
   */
  @OneToOne
  private MoneyEntity price;

  /**
   * shipping rate.
   */
  @OneToOne
  private ShippingRateValue shippingRate;

  /**
   * Set once the taxRate is set.
   */
  @OneToOne
  private TaxedItemPriceValue taxedPrice;

  /**
   * Will be set automatically in the Platform TaxMode once the shipping address is set is set. For
   * the External tax mode the tax rate has to be set explicitly with the ExternalTaxRateDraft.
   */
  @OneToOne
  private TaxRateValue taxRate;

  /**
   * tax category id.
   */
  @Column(name = "tax_category")
  private String taxCategory;

  /**
   * shipping method.
   */
  @Column(name = "shipping_method")
  private String shippingMethod;

  /**
   * delivery ids.
   */
  @Column(name = "deliveries", columnDefinition = "JSON")
  @Convert(converter = ListJsonConverter.class)
  private List<String> deliveries;


  /**
   * DiscountedLineItemPrice id.
   */
  @Column
  private String discountedPrice;

  /**
   * Gets shipping method name.
   *
   * @return the shipping method name
   */
  public String getShippingMethodName() {
    return shippingMethodName;
  }

  /**
   * Sets shipping method name.
   *
   * @param shippingMethodName the shipping method name
   */
  public void setShippingMethodName(String shippingMethodName) {
    this.shippingMethodName = shippingMethodName;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public MoneyEntity getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(MoneyEntity price) {
    this.price = price;
  }

  /**
   * Gets shipping rate.
   *
   * @return the shipping rate
   */
  public ShippingRateValue getShippingRate() {
    return shippingRate;
  }

  /**
   * Sets shipping rate.
   *
   * @param shippingRate the shipping rate
   */
  public void setShippingRate(ShippingRateValue shippingRate) {
    this.shippingRate = shippingRate;
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
   * Gets shipping method.
   *
   * @return the shipping method
   */
  public String getShippingMethod() {
    return shippingMethod;
  }

  /**
   * Sets shipping method.
   *
   * @param shippingMethod the shipping method
   */
  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  /**
   * Gets deliveries.
   *
   * @return the deliveries
   */
  public List<String> getDeliveries() {
    return deliveries;
  }

  /**
   * Sets deliveries.
   *
   * @param deliveries the deliveries
   */
  public void setDeliveries(List<String> deliveries) {
    this.deliveries = deliveries;
  }

  /**
   * Gets discounted price.
   *
   * @return the discounted price
   */
  public String getDiscountedPrice() {
    return discountedPrice;
  }

  /**
   * Sets discounted price.
   *
   * @param discountedPrice the discounted price
   */
  public void setDiscountedPrice(String discountedPrice) {
    this.discountedPrice = discountedPrice;
  }
}
