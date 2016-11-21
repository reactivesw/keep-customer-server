package io.reactivesw.cartdiscounts.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.models.LocalizedString;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class CartDiscountDraft {

  /**
   * The Name.
   */
  private LocalizedString name;

  /**
   * The Description.
   */
  private LocalizedString description;

  /**
   * The Value.
   */
  private CartDiscountValue value;

  /**
   * A valid CartDiscount predicate.
   */
  private String cartPredicate;

  /**
   * The Target.
   */
  private CartDiscountTarget target;


  /**
   * The string must contain a number between 0 and 1.
   * A discount with greater sort order is prioritized higher than a discount with lower sort order.
   * The sort order must be unambiguous among all carts discounts.
   */
  private String sortOrder;

  /**
   * Only active discount can be applied to the carts.
   */
  private Boolean isActive;

  /**
   * The Valid from.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime validFrom;

  /**
   * The Valid until.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime validUntil;

  /**
   * States whether the discount can only be used in a connection with a DiscountCode.
   */
  private Boolean requiresDiscountCode;

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public LocalizedString getDescription() {
    return description;
  }

  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  public CartDiscountValue getValue() {
    return value;
  }

  public void setValue(CartDiscountValue value) {
    this.value = value;
  }

  public String getCartPredicate() {
    return cartPredicate;
  }

  public void setCartPredicate(String cartPredicate) {
    this.cartPredicate = cartPredicate;
  }

  public CartDiscountTarget getTarget() {
    return target;
  }

  public void setTarget(CartDiscountTarget target) {
    this.target = target;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public ZonedDateTime getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(ZonedDateTime validFrom) {
    this.validFrom = validFrom;
  }

  public ZonedDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(ZonedDateTime validUntil) {
    this.validUntil = validUntil;
  }

  public Boolean getRequiresDiscountCode() {
    return requiresDiscountCode;
  }

  public void setRequiresDiscountCode(Boolean requiresDiscountCode) {
    this.requiresDiscountCode = requiresDiscountCode;
  }
}
