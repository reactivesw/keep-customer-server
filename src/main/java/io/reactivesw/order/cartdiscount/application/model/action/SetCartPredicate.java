package io.reactivesw.order.cartdiscount.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by umasuo on 16/12/21.
 */
@ApiModel
@Data
public class SetCartPredicate implements UpdateAction {

  /**
   * A valid CartDiscount predicate.
   */
  private String cartPredicate;

}
