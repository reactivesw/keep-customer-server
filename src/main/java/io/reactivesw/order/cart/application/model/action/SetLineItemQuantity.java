package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.infrastructure.util.CartUpdateActionUtils;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Set the LineItem quantity, minimum is 1.
 * cart.
 * Created by umasuo on 16/12/5.
 */
@ApiModel
@Data
public class SetLineItemQuantity implements UpdateAction {

  /**
   * line item id.
   * required.
   */
  @NotNull
  private String lineItemId;

  /**
   * quantity.
   * required.
   * the minimum is 1.
   */
  @NotNull
  private Integer quantity;

  @Override
  public String getActionName() {
    return CartUpdateActionUtils.SET_LINE_ITEM_QUANTITY;
  }
}
