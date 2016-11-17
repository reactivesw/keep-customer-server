package io.reactivesw.customer.server.cart.models.draft;

import java.util.List;

import io.reactivesw.customer.server.cart.models.CartDiscountPredicate;
import io.reactivesw.customer.server.cart.models.CartPredicate;
import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;
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

  @ApiModelProperty(value = "The discount code can only be applied to carts that match this predicate.",
          required = false)
  CartPredicate cartPredicate;

  @ApiModelProperty(required = true)
  private Boolean isActive;

  @ApiModelProperty(value = "The discount code can only be applied maxApplications times.",
          required = false)
  private Integer maxApplications;

  @ApiModelProperty(value = "The discount code can only be applied maxApplicationsPerCustomer times per customer.",
          required = true)
  private Integer maxApplicationsPerCustomer;

}
