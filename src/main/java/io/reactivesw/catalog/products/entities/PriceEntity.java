package io.reactivesw.catalog.products.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.reactivesw.catalog.productdiscounts.models.DiscountedPrice;
import io.reactivesw.common.entities.BaseIdEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Reference;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.DiscountedPriceJsonConverter;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;
import io.reactivesw.common.utils.MoneyJsonConverter;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_price")
public class PriceEntity extends BaseIdEntity{

  @Column(name = "value", nullable = false, columnDefinition = "JSON")
  @Convert(converter = MoneyJsonConverter.class)
  private Money value;

  @Column(name = "country")
  private String country;

  @Column(name = "customer_group_id")
  private String customerGroup;

  @Column(name = "chanel_id")
  private String channel;

  @Column(name = "valid_from")
  private ZonedDateTime validFrom;

  @Column(name = "valid_until")
  private ZonedDateTime validUntil;

  @Column(name = "discounted", columnDefinition = "JSON")
  @Convert(converter = DiscountedPriceJsonConverter.class)
  private DiscountedPrice discounted;

  @Column(name = "custom", columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "PriceEntity{" +
        "id='" + id + '\'' +
        ", value=" + value +
        ", country='" + country + '\'' +
        ", customerGroup='" + customerGroup + '\'' +
        ", channel='" + channel + '\'' +
        ", validFrom=" + validFrom +
        ", validUntil=" + validUntil +
        ", discounted=" + discounted +
        ", custom=" + custom +
        '}';
  }
}
