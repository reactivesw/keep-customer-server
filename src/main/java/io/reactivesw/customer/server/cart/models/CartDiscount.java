package io.reactivesw.customer.server.cart.models;

import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class CartDiscount {

  /**
   * The unique ID of the product discount
   */
  private String id;

  /**
   * The current version of the product discount.
   */
  private Integer version;

  /**
   * The Created at.
   */
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  private ZonedDateTime lastModifiedAt;

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
   * All matching cart discounts are applied to a cart in the order defined by this field.
   * A discount with greater sort order is prioritized higher than a discount with lower sort order.
   * The sort order is unambiguous among all cart discounts.
   */
  private String sortOrder;

  /**
   * Only active discount can be applied to the cart.
   */
  private Boolean isActive;

  /**
   * The Valid from.
   */
  private ZonedDateTime validFrom;

  /**
   * The Valid until.
   */
  private ZonedDateTime validUntil;

  /**
   * States whether the discount can only be used in a connection with a DiscountCode.
   */
  private Boolean requiresDiscountCode;

  /**
   * The platform will generate this array from the predicate.
   * It contains the references of all the resources that are addressed in the predicate.
   */
  private List<Reference> references;
}
