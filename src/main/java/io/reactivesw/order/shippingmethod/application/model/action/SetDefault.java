package io.reactivesw.order.shippingmethod.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Data;

/**
 * Created by umasuo on 16/12/8.
 */
@Data
public class SetDefault implements UpdateAction {

  /**
   * The Is default.
   */
  private Boolean isDefault;
}
