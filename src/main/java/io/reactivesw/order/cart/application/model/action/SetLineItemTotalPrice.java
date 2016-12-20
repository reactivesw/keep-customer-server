package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.ExternalLineItemTotalPrice;
import lombok.Data;

/**
 * Sets the totalPrice and price of the line item and changes the priceMode of the line item to
 * ExternalTotal. If the external total price of the line item was already set and the
 * externalTotalPrice field of this update action is not given, the external price is unset and
 * the line item price mode is set back to Platform. Although both price and totalPrice are set
 * with this update action, only totalPrice will be used to calculate the total price of the cart.
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetLineItemTotalPrice implements UpdateAction {

  private String lineItemId;

  private ExternalLineItemTotalPrice externalTotalPrice;
}
