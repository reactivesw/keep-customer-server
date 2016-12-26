package io.reactivesw.order.cartdiscount.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import io.reactivesw.common.model.Base;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by umasuo on 16/11/17. TODO
 */
@Data
@EqualsAndHashCode(callSuper = false)
public final class CartDiscountPredicate extends Base {

  private final String predicate;

  @JsonCreator
  public CartDiscountPredicate(final String predicate) {
    this.predicate = predicate;
  }

}
