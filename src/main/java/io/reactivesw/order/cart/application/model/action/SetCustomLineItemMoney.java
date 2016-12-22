package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.common.model.Money;
import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCustomLineItemMoney {

  /**
   * custom line item id.
   */
  private String customLineItemId;

  /**
   * money.
   */
  private Money money;
}
