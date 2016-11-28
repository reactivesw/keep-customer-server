package io.reactivesw.orders.carts.entities.values;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.reactivesw.catalog.productdiscounts.models.DiscountedPrice;
import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.DiscountedPriceJsonConverter;
import io.reactivesw.common.utils.MoneyJsonConverter;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "orders_carts_price")
public class PriceValue extends BaseIdEntity {

  /**
   * value.
   */
  @Column(name = "value", nullable = false, columnDefinition = "JSON")
  @Convert(converter = MoneyJsonConverter.class)
  private Money value;

  /**
   * country.
   */
  @Column(name = "country")
  private String country;

  /**
   * customer group.
   */
  @Column(name = "customer_group_id")
  private String customerGroup;

  /**
   * channel.
   */
  @Column(name = "chanel_id")
  private String channel;

  /**
   * valid from.
   */
  @Column(name = "valid_from")
  private ZonedDateTime validFrom;

  /**
   * valid until.
   */
  @Column(name = "valid_until")
  private ZonedDateTime validUntil;

  /**
   * discounted price.
   */
  @Column(name = "discounted", columnDefinition = "JSON")
  @Convert(converter = DiscountedPriceJsonConverter.class)
  private DiscountedPrice discounted;

  /**
   * custom fields.
   */
  @Column(name = "custom", columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  /**
   * to string method.
   */
  @Override
  public String toString() {
    return "PriceValue{" +
            "value=" + value +
            ", country='" + country + '\'' +
            ", customerGroup='" + customerGroup + '\'' +
            ", channel='" + channel + '\'' +
            ", validFrom=" + validFrom +
            ", validUntil=" + validUntil +
            ", discounted=" + discounted +
            ", custom=" + custom +
            '}';
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public Money getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(Money value) {
    this.value = value;
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
   * Gets channel.
   *
   * @return the channel
   */
  public String getChannel() {
    return channel;
  }

  /**
   * Sets channel.
   *
   * @param channel the channel
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  /**
   * Gets valid from.
   *
   * @return the valid from
   */
  public ZonedDateTime getValidFrom() {
    return validFrom;
  }

  /**
   * Sets valid from.
   *
   * @param validFrom the valid from
   */
  public void setValidFrom(ZonedDateTime validFrom) {
    this.validFrom = validFrom;
  }

  /**
   * Gets valid until.
   *
   * @return the valid until
   */
  public ZonedDateTime getValidUntil() {
    return validUntil;
  }

  /**
   * Sets valid until.
   *
   * @param validUntil the valid until
   */
  public void setValidUntil(ZonedDateTime validUntil) {
    this.validUntil = validUntil;
  }

  /**
   * Gets discounted.
   *
   * @return the discounted
   */
  public DiscountedPrice getDiscounted() {
    return discounted;
  }

  /**
   * Sets discounted.
   *
   * @param discounted the discounted
   */
  public void setDiscounted(DiscountedPrice discounted) {
    this.discounted = discounted;
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
