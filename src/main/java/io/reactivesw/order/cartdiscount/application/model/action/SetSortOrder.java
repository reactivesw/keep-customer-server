package io.reactivesw.order.cartdiscount.application.model.action;

import lombok.Data;

/**
 * Created by umasuo on 16/12/22.
 */
@Data
public class SetSortOrder implements CartDiscountUpdateAction {
  /**
   * new sort order.
   * The string must contain a number between 0 and 1.
   * A discount with greater sortOrder is prioritized higher than a discount with lower sortOrder.
   */
  private String sortOrder;
}
