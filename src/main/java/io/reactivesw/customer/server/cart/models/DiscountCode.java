package io.reactivesw.customer.server.cart.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;
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

  @ApiModelProperty(value = "The discount code can only be applied to carts that match this predicate.",
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


}
