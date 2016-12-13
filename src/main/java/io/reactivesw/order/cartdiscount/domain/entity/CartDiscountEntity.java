package io.reactivesw.order.cartdiscount.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/9.
 */
@Entity
@Table(name = "order_cart_discount_discount")
public class CartDiscountEntity extends BaseAllEntity {

  /**
   * The Version.
   */
  @Column
  private Integer version;

  /**
   * The Name.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * The Description.
   */
  @OneToMany
  private Set<LocalizedStringEntity> description;

  /**
   * The Value.
   */
  @OneToOne
  private CartDiscountValue value;

  /**
   * The Cart predicate.
   * For now, we only support 'totalPrice'.
   * if null, then apply to all carts.
   */
  @Column
  private String cartPredicate;

  /**
   * The Target.
   */
  @OneToOne
  private CartDiscountTargetValue target;

  /**
   * The Sort order.
   */
  @Column
  private String sortOrder;

  /**
   * The Active.
   */
  @Column
  private Boolean active;

  /**
   * The Valid from.
   */
  @Column
  private ZonedDateTime validFrom;

  /**
   * The Valid until.
   */
  @Column
  private ZonedDateTime validUntil;

  /**
   * The Requires discount code.
   */
  @Column
  private Boolean requiresDiscountCode;

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
   * Gets description.
   *
   * @return the description
   */
  public Set<LocalizedStringEntity> getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(Set<LocalizedStringEntity> description) {
    this.description = description;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public CartDiscountValue getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(CartDiscountValue value) {
    this.value = value;
  }

  /**
   * Gets cart predicate.
   *
   * @return the cart predicate
   */
  public String getCartPredicate() {
    return cartPredicate;
  }

  /**
   * Sets cart predicate.
   *
   * @param cartPredicate the cart predicate
   */
  public void setCartPredicate(String cartPredicate) {
    this.cartPredicate = cartPredicate;
  }

  /**
   * Gets target.
   *
   * @return the target
   */
  public CartDiscountTargetValue getTarget() {
    return target;
  }

  /**
   * Sets target.
   *
   * @param target the target
   */
  public void setTarget(CartDiscountTargetValue target) {
    this.target = target;
  }

  /**
   * Gets sort order.
   *
   * @return the sort order
   */
  public String getSortOrder() {
    return sortOrder;
  }

  /**
   * Sets sort order.
   *
   * @param sortOrder the sort order
   */
  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }

  /**
   * Gets active.
   *
   * @return the active
   */
  public Boolean getActive() {
    return active;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(Boolean active) {
    this.active = active;
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
   * Gets requires discount code.
   *
   * @return the requires discount code
   */
  public Boolean getRequiresDiscountCode() {
    return requiresDiscountCode;
  }

  /**
   * Sets requires discount code.
   *
   * @param requiresDiscountCode the requires discount code
   */
  public void setRequiresDiscountCode(Boolean requiresDiscountCode) {
    this.requiresDiscountCode = requiresDiscountCode;
  }
}
