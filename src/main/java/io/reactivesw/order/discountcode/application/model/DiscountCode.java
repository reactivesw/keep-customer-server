package io.reactivesw.order.discountcode.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.order.cartdiscount.model.CartDiscountPredicate;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class DiscountCode {

  @ApiModelProperty(value = "The unique ID of the discount code.", required = true)
  private String id;

  @ApiModelProperty(required = true)
  private Integer version;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

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
  private CartDiscountPredicate cartPredicate;

  @ApiModelProperty(required = true)
  private Boolean isActive;

  @ApiModelProperty(value = "The platform will generate this array from the cartPredicate. " +
          "It contains the references of all the resources that are addressed in the predicate.",
          required = true)
  private List<Reference> references;

  @ApiModelProperty(value = "The discount code can only be applied maxApplications times.",
          required = false)
  private Integer maxApplications;

  @ApiModelProperty(value = "The discount code can only be applied maxApplicationsPerCustomer times per customer.",
          required = true)
  private Integer maxApplicationsPerCustomer;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

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

  public CartDiscountPredicate getCartPredicate() {
    return cartPredicate;
  }

  public void setCartPredicate(CartDiscountPredicate cartPredicate) {
    this.cartPredicate = cartPredicate;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public List<Reference> getReferences() {
    return references;
  }

  public void setReferences(List<Reference> references) {
    this.references = references;
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
