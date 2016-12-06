package io.reactivesw.orders.carts.applications.models.actions;

import io.reactivesw.common.models.UpdateAction;
import io.swagger.annotations.ApiModel;

/**
 * Decreases the quantity of the given LineItem. If after the update the quantity of the line
 * item is not greater than 0 or the quantity is not specified, the line item is removed from the
 * cart.
 * Created by umasuo on 16/12/5.
 */
@ApiModel
public class RemoveLineItem implements UpdateAction {

  /**
   * line item id.
   */
  private String lineItemId;

  /**
   * quantity.
   */
  private Integer quantity;

  /**
   * Gets line item id.
   *
   * @return the line item id
   */
  public String getLineItemId() {
    return lineItemId;
  }

  /**
   * Sets line item id.
   *
   * @param lineItemId the line item id
   */
  public void setLineItemId(String lineItemId) {
    this.lineItemId = lineItemId;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * to string method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "RemoveLineItem{"
        + "lineItemId='" + lineItemId + '\''
        + ", quantity=" + quantity
        + '}';
  }
}
