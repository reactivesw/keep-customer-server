package io.reactivesw.order.cartdiscount.application.model.action;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by umasuo on 16/12/21.
 */
@ApiModel
@Data
public class SetCartPredicate implements CartDiscountUpdateAction {

  /**
   * A valid CartDiscount predicate.
   */
  private String cartPredicate;

}
