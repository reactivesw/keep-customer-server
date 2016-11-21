package io.reactivesw.cartdiscounts.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import io.reactivesw.common.models.Base;

/**
 * Created by umasuo on 16/11/17. TODO
 */
public final class CartDiscountPredicate extends Base {
  private final String predicate;

  @JsonCreator
  public CartDiscountPredicate(final String predicate) {
    this.predicate = predicate;
  }
}
