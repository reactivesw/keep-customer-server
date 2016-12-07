package io.reactivesw.order.discountcode.application.model;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountCodeDraft {

  @ApiModelProperty(required = false)
  private LocalizedString name;

  @ApiModelProperty(required = false)
  private LocalizedString description;

  @ApiModelProperty(value = "Unique identifier of this discount code. " +
      "This value is added to the cart to enable the related cart discounts in the cart.",
      required = true)
  private String code;

  @ApiModelProperty(value = "The referenced matching cart discounts can be applied to the cart " +
      "once the DiscountCode is added.",
      required = true)
  private List<Reference> cartDiscounts;

  @ApiModelProperty(value = "The discount code can only be applied to cart that match this " +
      "predicate.",
      required = false)
  private String cartPredicate;

  @ApiModelProperty(required = true)
  private Boolean isActive;

  @ApiModelProperty(value = "The discount code can only be applied maxApplications times.",
      required = false)
  private Integer maxApplications;

  @ApiModelProperty(value = "The discount code can only be applied maxApplicationsPerCustomer " +
      "times per customer.",
      required = true)
  private Integer maxApplicationsPerCustomer;

  /**
   * Gets name.
   *
   * @return the name
   */
  public LocalizedString getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(LocalizedString name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public LocalizedString getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Gets cart discounts.
   *
   * @return the cart discounts
   */
  public List<Reference> getCartDiscounts() {
    return cartDiscounts;
  }

  /**
   * Sets cart discounts.
   *
   * @param cartDiscounts the cart discounts
   */
  public void setCartDiscounts(List<Reference> cartDiscounts) {
    this.cartDiscounts = cartDiscounts;
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
   * Gets active.
   *
   * @return the active
   */
  public Boolean getActive() {
    return isActive;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(Boolean active) {
    isActive = active;
  }

  /**
   * Gets max applications.
   *
   * @return the max applications
   */
  public Integer getMaxApplications() {
    return maxApplications;
  }

  /**
   * Sets max applications.
   *
   * @param maxApplications the max applications
   */
  public void setMaxApplications(Integer maxApplications) {
    this.maxApplications = maxApplications;
  }

  /**
   * Gets max applications per customer.
   *
   * @return the max applications per customer
   */
  public Integer getMaxApplicationsPerCustomer() {
    return maxApplicationsPerCustomer;
  }

  /**
   * Sets max applications per customer.
   *
   * @param maxApplicationsPerCustomer the max applications per customer
   */
  public void setMaxApplicationsPerCustomer(Integer maxApplicationsPerCustomer) {
    this.maxApplicationsPerCustomer = maxApplicationsPerCustomer;
  }
}
