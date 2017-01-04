package io.reactivesw.order.shippingmethod.application.model.action;

import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import lombok.Data;

/**
 * Created by umasuo on 16/12/8.
 * this action used for add or remove shipping method
 */
@Data
public class AddShippingRate implements UpdateAction {

  /**
   * The Zone.
   */
  private Reference zone;

  /**
   * The Shipping rate.
   */
  private ShippingRate shippingRate;

  /**
   * action name.
   *
   * @return String
   */
  @Override
  public String getActionName() {
    return "addShippingRate";
  }
}
