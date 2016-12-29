package io.reactivesw.order.shippingmethod.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.Reference;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;

/**
 * Created by umasuo on 16/12/8.
 * this action used for add or remove shipping method
 */
public class RemoveShippingRate implements UpdateAction {

  /**
   * The Zone.
   */
  private Reference zone;

  /**
   * The Shipping rate.
   */
  private ShippingRate shippingRate;

  /**
   * Gets zone.
   *
   * @return the zone
   */
  public Reference getZone() {
    return zone;
  }

  /**
   * Sets zone.
   *
   * @param zone the zone
   */
  public void setZone(Reference zone) {
    this.zone = zone;
  }

  /**
   * Gets shipping rate.
   *
   * @return the shipping rate
   */
  public ShippingRate getShippingRate() {
    return shippingRate;
  }

  /**
   * Sets shipping rate.
   *
   * @param shippingRate the shipping rate
   */
  public void setShippingRate(ShippingRate shippingRate) {
    this.shippingRate = shippingRate;
  }

  @Override
  public String getActionName() {
    return null;
  }
}
