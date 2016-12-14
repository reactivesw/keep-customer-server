package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.CustomFieldsDraft;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class PriceDraft {

  /**
   * The Value.
   */
  private Money value;

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 .
   */
  private String country;

  /**
   * A reference to a customer group.
   */
  private Reference customerGroup;

  /**
   * A reference to a channel.
   */
  private Reference channel;

  /**
   * Date from which the price is valid.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime validFrom;

  /**
   * Date until which the price is valid.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime validUntil;

  /**
   * The custom fields.
   */
  private CustomFieldsDraft custom;

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
  public Reference getCustomerGroup() {
    return customerGroup;
  }

  /**
   * Sets customer group.
   *
   * @param customerGroup the customer group
   */
  public void setCustomerGroup(Reference customerGroup) {
    this.customerGroup = customerGroup;
  }

  /**
   * Gets channel.
   *
   * @return the channel
   */
  public Reference getChannel() {
    return channel;
  }

  /**
   * Sets channel.
   *
   * @param channel the channel
   */
  public void setChannel(Reference channel) {
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
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFieldsDraft getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "PriceDraft{" +
        "value=" + value +
        ", country='" + country + '\'' +
        ", customerGroup=" + customerGroup +
        ", channel=" + channel +
        ", validFrom=" + validFrom +
        ", validUntil=" + validUntil +
        ", custom=" + custom +
        '}';
  }
}
