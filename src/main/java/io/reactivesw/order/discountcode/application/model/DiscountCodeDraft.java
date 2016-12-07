package io.reactivesw.order.discountcode.application.model;

import java.util.List;

import io.reactivesw.order.cart.application.model.CartPredicate;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

  @ApiModelProperty(value = "The referenced matching cart discounts can be applied to the cart once the DiscountCode is added.",
          required = true)
  private List<Reference> cartDiscounts;

  @ApiModelProperty(value = "The discount code can only be applied to cart that match this predicate.",
          required = false)
  private CartPredicate cartPredicate;

  @ApiModelProperty(required = true)
  private Boolean isActive;

  @ApiModelProperty(value = "The discount code can only be applied maxApplications times.",
          required = false)
  private Integer maxApplications;

  @ApiModelProperty(value = "The discount code can only be applied maxApplicationsPerCustomer times per customer.",
          required = true)
  private Integer maxApplicationsPerCustomer;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<Reference> getCartDiscounts() {
    return cartDiscounts;
  }

  public void setCartDiscounts(List<Reference> cartDiscounts) {
    this.cartDiscounts = cartDiscounts;
  }

  public CartPredicate getCartPredicate() {
    return cartPredicate;
  }

  public void setCartPredicate(CartPredicate cartPredicate) {
    this.cartPredicate = cartPredicate;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public Integer getMaxApplications() {
    return maxApplications;
  }

  public void setMaxApplications(Integer maxApplications) {
    this.maxApplications = maxApplications;
  }

  public Integer getMaxApplicationsPerCustomer() {
    return maxApplicationsPerCustomer;
  }

  public void setMaxApplicationsPerCustomer(Integer maxApplicationsPerCustomer) {
    this.maxApplicationsPerCustomer = maxApplicationsPerCustomer;
  }
}
